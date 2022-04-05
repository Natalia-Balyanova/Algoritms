package src.balyanova.lesson2;

import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;

public class Notebook implements Comparable<Notebook>{
//    final int SIZE = 10000;
    BigDecimal price;
    int memory;
    Manufacturer manufacturer;
    UUID serialId = UUID.randomUUID();

    public Notebook(BigDecimal price, int memory, Manufacturer manufacturer) {
        this.price = price;
        this.memory = memory;
        this.manufacturer = manufacturer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public UUID getSerialId() {
        return serialId;
    }

    public void setSerialId(UUID serialId) {
        this.serialId = serialId;
    }

    public enum Manufacturer {
        LENUVO, ASOS, MACNOTE, ESER, XAMIOU
    }

    @Override
    public int compareTo(Notebook o) {//сравнение объектов
        int result = price.compareTo(o.getPrice());
        if(result == 0) {
            result = Integer.compare(memory, o.getMemory());
            if(result == 0) {
                return manufacturer.compareTo(o.getManufacturer());
            }
            return result;
        }
        return result;
    }

    @Override
    public String toString() {
        return "Notebook {" +
                "serialId =" + serialId +
                ", price = " + price +
                ", memory = " + memory +
                ", manufacturer = '" + manufacturer + '\n' +
                '}';
    }
}
