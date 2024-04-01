package org.example;

public class VendingMachine {
    public static void Main(String[] args){

                private State vendingMachineState;
                private Inventory inventory;
                private List<Coint> coinList;

                pubilc VendingMachine(){
                    vendingMachineState = new IdleState();
                    inventory = new Inventory(10);
                    cointList = new ArrayList<>();
                }

                public State getVendingMachineState(){
                    return vendingMachineState;
                }

                public void setVendingMachineState(State vendingMachineState){
                    this.vendingMachineState = vendingMachineState;
                }

                public Inventory getInventorty(){
                    return inventory;
                }

                public void setInventory(Inventory inventory){
                    this.inventory = inventory;
                }

                public List<Coin> getCoinList(){
                    return coinList;
                }

                public void setCoinList(List<Coin>coinList){
                    this.coinList  = coinList;
                }

    }
}