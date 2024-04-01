public class SelectionState implements State{
    
    public SelectionState(){
        System.out.println("Currently vendinf machine is in selectionstate");
    }

    @Override
    public void ClickOnInsertCoinButton(VendingMachine machine)throws Exception{
        throw new Exception("You can not click on the insert coin button in selectoin state");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine)throws Exception{
        return;
    }

    @Override
    public void insertCoin(VendingMachine machine, Coint coin)throws Exception{
        throw new Exception("You cannot insert coin in selection state");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber)throws Exception{
        //get the item of given codeNumber
        Item item = machine.getInventory().getItem(codeNumber);

        //total amount paid by the user
        int paidByUser  = 0;
        for(Coin coin: machine.getCoinList()){
            paidByUser = paidByUser + coin.value;
        }

        //compare product price and amount paid by user
        if(paidByUser < item.getPrice()){
            System.out.println("Insufficient Amount, Product you selected is for price"+ item.getPrice() + "and you paid:" + paidByUser);
            refundFullMoney(machine);
            throw new Exception("Insufficient amount");
        }
        else if(paidByUser >= item.getPrice()){
            if(paidByUser > item.getPrice()){
                getChange(paidByUser - item.getPrice());
            }
            machine.setVendingMachineState(new DispenseState(machine,codeNumber));
        }
    }

    @Override
    public int getChange(int returnExtraMoney) throws Exception{
        System.out.println("Returnd the change in the coin dispense tray:"+ returnExtraMoney);
        return returnExtraMoney;
    }

    @Override
    public List<Coin>refundFullMoney(VendingMachine machine)throws Exception{
        System.out.println("Returned the full amount back in the coin dispense tray");
        return machine.getCoinList();
    }

    @Override
    public Item dispenseState(VendingMachine machine, int codeNumber)throws Exception{
        throw new Exception("Product cannot be dispensed selection state");
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber)throws Exception{
        throw new Exception("Inventory cannot be updated in selection state");
    }

}