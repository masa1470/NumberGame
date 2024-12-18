package number;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import bean.GameSessionBean;
import dao.GameDAO;
import dao.GameSessionDAO;

@WebServlet("/result")
public class GameResultServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/NumberGame";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "admin";

    private GameDAO gameDAO;

    @Override
    public void init() throws ServletException {
        gameDAO = new GameDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエスト属性から値を取得し、型に適切にキャスト
        int guess = (int) request.getAttribute("guess");
        Boolean correct = (Boolean) request.getAttribute("correct");  // Booleanにキャスト
        String hint = (String) request.getAttribute("hint");
        int attempts = (int) request.getAttribute("attempts");

        // ゲーム結果を保存
        gameDAO.saveGameResult(guess, correct, hint);

        // 正解の場合、セッションを保存
        if (correct != null && correct) {
            GameSessionBean gameSession = new GameSessionBean();
            gameSession.setPlayerId(1); // 仮のプレイヤーID
            gameSession.setAttempts(attempts);
            gameSession.setClearTime(new Timestamp(System.currentTimeMillis()));
            gameSession.setResult("Cleared");

            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                GameSessionDAO gameSessionDAO = new GameSessionDAO(connection);
                gameSessionDAO.saveGameSession(gameSession);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // リクエスト属性を設定して、JSPに渡す
        String message = (correct != null && correct) ? "正解！" : "不正解";
        request.setAttribute("message", message);
        request.setAttribute("hint", hint);

        // JSPに結果をフォワード
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
