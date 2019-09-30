package ua.ithillel.hw71.classes;

import ua.ithillel.hw71.classes.Flower;
import ua.ithillel.hw71.interfaces.InterfaceBouquet;
import ua.ithillel.hw71.utils.Check;

public class Bouquet implements InterfaceBouquet {

    private Flower[] flowers;

    public Bouquet(int count) {
        flowers = new Flower[count];
    }

    public Flower[] getFlowers() {
        return this.flowers;
    }

    @Override
    public void addFlower(Flower flower) {
if (Check.chekLength(this.flowers)){
    int position = Check.getPosition(this.flowers);
    this.flowers[position] = flower;
}else
    System.out.println("error");
    }

    @Override
    public float getBouquetCost() {
        float tmpPrice = 0.00f;
        for (Flower flower : this.flowers) {
            if (flower != null)
                tmpPrice += flower.getPrice();
            else
                break;
        }
        return tmpPrice;
    }

}

