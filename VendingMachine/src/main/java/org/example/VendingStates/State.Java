
import java.util.List;

public interface State{

    public void clickOnInsertCoinButton(VendingMachine machine)throws Exception;
    public void clickOnStartProductSelectionButton(VendingMachine machine)throws Exception;
    public void insertCoin(VendingMachine machine, Coin coin)thrwos Exception;
    public void chooseProduct(VendingMachine machine, int codeNumber)throws Exception;
    public int getChange(int returnChangeMoney)throws Exception;
    pubilc Item dispenseProduct(VendingMaching machine)throws Exception;
    public void updateInventory(VendingMachine machine, Item Item, int codeNumber)throws Exception;

}