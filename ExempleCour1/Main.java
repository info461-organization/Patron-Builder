class Pizza {
    private String pate = "";
    private String sauce = "";
    private String garniture = "";

    Pizza(){}

    public void setPlate(String pate){
        this.pate = pate;
    }

    public void setSauce(String sauce){
        this.sauce = sauce;
    }

    public void setGarniture(String garniture){
        this.garniture = garniture;
    }

    public void print(){
        System.out.println(this.toString());
        System.out.println("Pate = " + this.pate + "\nSauce = " + this.sauce + "\nGarniture = " + this.garniture);
    }
}

class Directeur{
    public Pizza contruirePizzaPiquante(){
        MonteurPizza pizza = new MonteurPizzaPiquante();
        return pizza.getPizza();
    }

    public Pizza contruirePizzaReine(){
        MonteurPizza pizza = new MonteurPizzaReine();
        return pizza.getPizza();
    }
}

abstract class MonteurPizza {
    protected Pizza pizza = new Pizza();

    public Pizza getPizza(){
        monterPate();
        monterSauce();
        monterGarniture();
        return pizza;
    }

    public abstract void monterPate();
    public abstract void monterSauce();
    public abstract void monterGarniture();
}

class MonteurPizzaPiquante extends MonteurPizza {
    public void monterPate(){
        pizza.setPlate("feuilletee");
    }

    public void monterSauce(){
        pizza.setSauce("piquante");
    }

    public void monterGarniture(){
        pizza.setGarniture("pepperonni+salami");
    }
}

class MonteurPizzaReine extends MonteurPizza {
    public void monterPate(){
        pizza.setPlate("croisee");
    }

    public void monterSauce(){
        pizza.setSauce("douce");
    }

    public void monterGarniture(){
        pizza.setGarniture("jambon+champignon");
    }
}

class Main {
    public static void main(String[] args){
        Directeur directeur = new Directeur();

        System.out.println("Pizza reine Fabirque");
        directeur.contruirePizzaReine().print();

        System.out.println("Pizza reine piquante");
        directeur.contruirePizzaPiquante().print();
    }
}