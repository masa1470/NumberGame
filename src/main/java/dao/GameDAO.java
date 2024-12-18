package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class GameDAO {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/NumberGame";
    private static final String DB_USER = "postgres"; // PostgreSQLのユーザー名
    private static final String DB_PASSWORD = "admin"; // PostgreSQLのパスワード

    public void saveGameResult(int guess, boolean correct, String hint) {
        try {
            Class.forName("org.postgresql.Driver");  // PostgreSQL JDBCドライバを明示的にロード
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String query = "INSERT INTO public.game_results (guess, correct, hint) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, guess);
            stmt.setBoolean(2, correct);
            stmt.setString(3, hint);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(); // エラー出力
        }
    }

    // 古いゲームデータを削除するメソッド
    public void deleteAllGameResults() {
        String query = "DELETE FROM game_results WHERE played_at <= NOW() - INTERVAL '1 minute';\n";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            int rowsDeleted = stmt.executeUpdate();
            System.out.println("Deleted " + rowsDeleted + " old game results.");
            
        } catch (Exception e) {
            e.printStackTrace(); // エラー出力
        }
    }
}