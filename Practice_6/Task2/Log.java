import java.util.Date;

public class Log {
    private String userName; //имя пользователя
    private String action; //действие
    private Date date; //дата
    private String comment; //комментарий

    //конструктор
    public Log(String userName, String action, String comment, Date date){
        this.userName = userName;
        this.action = action;
        this.date = date;
        this.comment = comment;
    }

    //конструктор с установкой текущей даты
    public Log(String userName, String action, String comment) {
        this.userName = userName;
        this.action = action;
        this.comment = comment;
        this.date = new Date();
    }

    //геттеры
    public String getUserName() {
        return userName;
    }
    public String getAction() {
        return action;
    }
    public Date getDate() {
        return date;
    }
    public String getComment() {
        return comment;
    }

}
