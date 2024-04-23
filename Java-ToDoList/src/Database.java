import java.sql.*;
public class Database {
    private Set<ToDos> todos = new HashSet<ToDos>();

    public Database(){
        String url;
        Connection con;
        String queryText;
        Statement stmt;
        try {
            url = "jdbc:mysql://127.0.0.1/employees";
            con = DriverManager.getConnection(url, "root", "");
            stmt = con.createStatement();

            queryText = "create table ToDo (text varchar(500), ID int)";

            stmt.executeUpdate(queryText);
            stmt.close();
            con.close();
        } catch (SQLException ex) { System.err.println("SQLException: " + ex.getMessage());
    }

    public ToDOs getToDOs() {
        return todos;
    }

    // public ToDOs setToDOs(Set<ToDos> todos) {
    //     todos = todos;
    // }

    public void writeToFile(String file){
        try(FileOutputStream fileOutputStream = new FileOutputStream(file)){
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            while (true) {
                for(ToDO todo: ToDos)
                    objectOutputStream.writebject(todo + "\n");
            }

        } catch(EOFException e){
            // This exception is raised because the whole file was read.
            // So print the users in the set.

            for (ToDO todo: ToDos) {
                System.out.println(todo);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            // Never forget to close the stream after you're done
            if (objectInputStream!=null) {
                objectOutputStream.close();
            }
    }

    public void readFromFile(String file){
        Set<User> users = new HashSet<User>();
        try(FileInputStream fileInputStream = new FileInputStream(file)){
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            while (true) {
                User user = (User) objectInputStream.readObject();
                users.add(user);    
            }

        } catch(EOFException e){
            // This exception is raised because the whole file was read.
            // So print the users in the set.

            for (User user : users) {
                System.out.println(user);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            // Never forget to close the stream after you're done
            if (objectInputStream!=null) {
                objectInputStream.close();
            }
    }

}