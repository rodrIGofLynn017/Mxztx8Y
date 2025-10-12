// 代码生成时间: 2025-10-13 02:52:20
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class CryptoWalletService {

    private static final Map<String, BigDecimal> wallets = new HashMap<>();

    // Initializes a new wallet with a unique ID and a balance of zero
    public String createWallet() {
        String walletId = UUID.randomUUID().toString();
        wallets.put(walletId, BigDecimal.ZERO);
        return walletId;
    }

    // Deposits an amount into the specified wallet
    public void deposit(String walletId, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Deposit amount must be positive."
            );
        }
        wallets.put(walletId, wallets.get(walletId).add(amount));
    }

    // Withdraws an amount from the specified wallet
    public void withdraw(String walletId, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Withdrawal amount must be positive."
            );
        }
        BigDecimal currentBalance = wallets.get(walletId);
        if (currentBalance.compareTo(amount) < 0) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Insufficient funds for withdrawal."
            );
        }
        wallets.put(walletId, currentBalance.subtract(amount));
    }

    // Retrieves the balance of the specified wallet
    public BigDecimal getBalance(String walletId) {
        if (!wallets.containsKey(walletId)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Wallet not found."
            );
        }
        return wallets.get(walletId);
    }
}
