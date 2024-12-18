package bean;


import java.io.Serializable;
import java.sql.Timestamp;

public class GameSessionBean implements Serializable {
    private static final long serialVersionUID = 1L; // シリアライズ用のユニークID
    private int sessionId;
    private int playerId;
    private int attempts;
    private Timestamp clearTime;
    private String result;

    // 引数なしのコンストラクタ（デフォルトコンストラクタ）
    public GameSessionBean() {}

    // ゲッターとセッター
    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public Timestamp getClearTime() {
        return clearTime;
    }

    public void setClearTime(Timestamp clearTime) {
        this.clearTime = clearTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}

