public class Pair<K,V> {
    private Integer key;
    private Integer value;
    public Pair(Integer k, Integer v){
        this.key=k;
        this.value=v;
    }
    public Integer getValue(){
        return value;
    }
    public Integer getKey(){
        return key;
    }
}
