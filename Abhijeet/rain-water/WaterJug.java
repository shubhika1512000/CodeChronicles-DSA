
public class WaterJug {
    
    public boolean canMeasureWater(int x, int y, int target) {
        int val = findGCD(x, y);
        if(x + y >= target && target % val == 0) return true;
        return false;
    }

    public int findGCD(int x, int y) { 
        int val = Math.max(x,y) % Math.min(x,y);

        if(val == 0) return Math.min(x,y);

        return findGCD(Math.min(x,y), val);
    }
}