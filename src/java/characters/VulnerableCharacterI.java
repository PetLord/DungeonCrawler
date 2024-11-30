package characters;

public interface VulnerableCharacterI {
    void receiveAttack(int damage);
    void heal(int healAmount);
    void die();
    int getCurrentHealth();
    boolean isAlive();
}
