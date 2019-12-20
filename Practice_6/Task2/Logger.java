import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

//класс работы с логами
public class Logger implements ILogWrite, ILogRead, ILogPrintInfo {

    //путь к логу
    private String logPath = "log.log";

    //разделитель в файле
    private String delimiter = " - ";

    //формат даты в логе
    private String dateFormatString = "[yyyy-MM-dd HH:mm:ss]";

    //пустой конструктор
    public Logger(){}

    //конструктор с указанием пути к логу
    public Logger(String logPath){
        this.logPath = logPath;
    }


    //TODO: правильно ли выносить реализацию в приватный метод, или необходимо реализовывать в данном методе интерфейса?
    //реализация метода записи лога
    @Override
    public boolean write(Log log) {
        //запись в файл
        return writeToFile(log);
    }

    //TODO: правильно ли выносить реализацию в приватный метод, или необходимо реализовывать в данном методе интерфейса?
    //реализация метода считывания лога
    @Override
    public List<Log> read(String logPath) {
        try {
            return readFromFile(Paths.get(logPath));
        } catch (ParseStringException e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    //вывод информации в разрезе по дням
    @Override
    public void printInfoByDays() {
        System.out.println("Вывод информации из лога в разрезе дней:");
        //считываем логфайл
        List<Log> logs = read(logPath);
        //TODO: убрать часть с сортировкой? по идее в лог-файле априори все строки добавляются последовательно по дате
        //компоратор для сравнения по датам
        Comparator<Log> dateComparetor = new Comparator<Log>() {
            @Override
            public int compare(Log o1, Log o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        };
        //сортируем по дате (хотя логи и так должны быть отсортированы)
        logs.sort(dateComparetor);

        //перебираем все строки лога
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String someDate = "";
        for(Log log: logs){
            if (!someDate.equals(df.format(log.getDate())) ){
                someDate = df.format(log.getDate());
                System.out.println(">>>> Дата: " + someDate);
            }
            System.out.println(logToStr(log));
        }
    }

    //вывод информации по пользователю
    @Override
    public void printInfoByUser(String userName) {
        //считываем логфайл
        List<Log> logs = read(logPath);
        System.out.println("Логи по пользователю " + userName);
        for (Log log: logs){
            if (log.getUserName().equals(userName))
                System.out.println(logToStr(log));
        }
    }

    //запись в файл
    private boolean writeToFile(Log log) {
        //дозаписываем файл
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(logPath, true))){
            bw.write(logToStr(log) + System.lineSeparator());
        } catch (IOException e){
            return false;
        }
        return true;
    }

    //преобразование лога (одной строки) в String
    private String logToStr(Log log){
        //формат даты для записи
        DateFormat dateFormat = new SimpleDateFormat(dateFormatString);
        //пишем в файл
        return dateFormat.format(log.getDate()) + delimiter + log.getUserName() + delimiter
                + log.getAction() + delimiter + log.getComment();
    }

    //чтение логов из файла
    private List<Log> readFromFile(Path logPath) throws ParseStringException{
        List<Log> logs = new ArrayList<>();
        try {
            //считываем все строки из файла
            List<String> lines =  Files.readAllLines(logPath, Charset.defaultCharset());
            //парсим в наш лист логов
            for(String line: lines){
                logs.add(parseFromString(line));
            }
        } catch (IOException|ParseException e){
            throw  new ParseStringException(e); //возвращаем нашу ошибку, но передаем туда вызвавшую ошибку
        } catch (ParseStringException e) {
            throw new ParseStringException(e.getMessage());
        }
        return logs;
    }

    //парсинг лога из строки
    private Log parseFromString(String str) throws ParseException, ParseStringException {
        String[] params = str.split(delimiter);
        Date date = new SimpleDateFormat(dateFormatString).parse(params[0]);
        if (params.length < 4)
            throw new ParseStringException("Ошибка парсинга строки: неверное число параметров после разбиения по делимитеру");
        return new Log(params[1], params[2], params[3], date);
    }
}
