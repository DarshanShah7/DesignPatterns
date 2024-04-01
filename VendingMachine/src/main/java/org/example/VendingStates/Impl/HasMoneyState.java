public class HasMoneyState implements State{

    pubilc HasMoneyState(){
        System.out.println("Currently vending machine is in hasmoneystate");
    }

    @Override
    public void clickonInsertCoinButton(VendingMachine machine)throws Exception{
        return;
    }

    public void clickOnStartProductSelectionButton(VendingMachine machine)throws Exception{
        machine.setVendingMachineState(new SelectionState());
    }

    @Override
    public void insertCoin(VendingMachine machine,Coin coin) throws Exception{
        System.out.println("Accepted the coin");
        machine.getCoinList().add(coin);
    }
    
    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber)throws Exception{
        throw new Exception("You need to clkck on the start product selection button first");
    }

    @Override
    

}