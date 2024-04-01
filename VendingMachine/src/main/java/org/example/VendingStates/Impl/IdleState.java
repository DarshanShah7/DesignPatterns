public class IdleState implements State{

    public IdleState(){
        System.out.println("Currently Vending machine is in Idlestate");
    }

    public IdleState(VendingMachine machine){
        System.out.println("Currently vending machine is in idlestate");
        machine.setCoinList(new ArrayList<>());
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine)throws Exception{
            machine.setVendingMachineState(new HasMoneyState());
    }

    @Override
    public void clickOnsStartProductSelectionButton(VendingMachine machine)throws Exception{
        throw new Exception("First you need to click on the insert coin button");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin)throws Exception{
        throw new Exception("First you need to click on insert coin button");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin)throws Exception{
        throw new Exception("You cannot insert a coin in idle state");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber)throws Exception{
        throw new Exception("You cannot choose product in idle state");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber)throws Exception{
        throw new Exception("Product cannot be dispensed in idle state");
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber)throws Exception{
        machine.getInventory().addItem(item,codeNumber);
    }


}