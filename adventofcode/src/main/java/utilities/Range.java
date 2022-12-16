package utilities;

public class Range implements Comparable<Range>{
    public int low, high;
    public Range(int a, int b){
        if(a <= b){
            low = a;
            high =b;
        } else {
            low = b;
            high = a;
        }
    }

    public Boolean contains(int i) {
        return low <= i && i <= high;
    }

    public int size(){
        return high-low + 1;
    }

    public int boundedSize(int min, int max){
        low = Math.max(low,min);
        high = Math.max(high,min);
        low = Math.min(low,max);
        high = Math.min(high,max);
        return high - low;
    }

    public Boolean merge(Range other) {

        //if one of the ranges contains the other
        if (contains(other.low) && contains(other.high)) {
            return true;
        } else if (other.contains(low) && other.contains(high)) {
            this.low = other.low;
            this.high = other.high;
            return true;
        }

        // if other contains our high, or is adjacent
        if (other.contains(high) || high - other.low == 0) {
            this.high = other.high;
            return true;
        }
        // if other contains our low, or is adjacent
        if (contains(other.high) || low - other.high == 0) {
            this.low = other.low;
            return true;
        }

        return false;
    }

    @Override
    public int compareTo(Range o) {
        return low - o.low;
    }

}
