package bean;

/**
 * Created by wangyushuai@fang.com on 2017/12/21.
 */
public class Hero {
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHp() {

        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private  String name;
    private float hp;
    private int damage;

}
