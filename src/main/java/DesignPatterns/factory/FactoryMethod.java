package DesignPatterns.factory;

/**
 * @author chenzeqin
 * date 2020/8/11
 */
public class FactoryMethod {
    public static void main(String[] args) {
        Factory factory = new FactoryA();
        Product product = factory.createProduct();
        product.show();
    }
}

interface Product{
    public void show();
}

class ProductA implements Product{
    public void show(){
        System.out.println("A");
    }
}
class ProductB implements Product{
    public void show(){
        System.out.println("B");
    }
}

abstract class Factory{
    abstract Product createProduct();
}

class FactoryA extends Factory{

    Product createProduct(){
        return new ProductA();
    }
}

class FactoryB extends Factory{
    Product createProduct(){
        return new ProductB();
    }
}
