import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Jdbi jdbi = Jdbi.create("jdbc:postgresql://localhost:5432/postgres", "postgres", "Mandarin");
        jdbi.useTransaction((Handle handle) -> {
            handle
                    .createUpdate("INSERT INTO users (firstName, lastName) VALUES (:firstName, :lastName)")
                    .bind("firstName", "Сергей")
                    .bind("lastName", "Серегеев")
                    .execute();
        });
    }
}


