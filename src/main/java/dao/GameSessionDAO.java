package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.GameSessionBean;

public class GameSessionDAO {

    private Connection connection;

    public GameSessionDAO(Connection connection) {
        this.connection = connection;
    }

    public void saveGameSession(GameSessionBean gameSession) throws SQLException {
        String query = "INSERT INTO game_sessions (player_id, attempts, clear_time, result) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, gameSession.getPlayerId());
            statement.setInt(2, gameSession.getAttempts());
            statement.setTimestamp(3, gameSession.getClearTime());
            statement.setString(4, gameSession.getResult());

            statement.executeUpdate();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}

