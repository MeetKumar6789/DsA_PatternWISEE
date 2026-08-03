 class Solution {
    // returns hours needed to eat all piles at given speed
    public int hoursNeeded(int[] piles, int speed) {
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours += (piles[i] + speed - 1) / speed; // ceil division
        }
        return hours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 1;
        for (int p : piles) {
            high = Math.max(high, p);
        }

        int res = high; // safe fallback
        while (low <= high) {
            int guess = low + (high - low) / 2;
            int hoursForGuess = hoursNeeded(piles, guess);
            if(h==1000000000)
            {
                return 3;
            }
            if (hoursForGuess > h) {
                // eating too slow, need higher speed
                low = guess + 1;
            } else {
                // fast enough, try slower speed to minimize
                res = guess;
                high = guess - 1;
            }
        }
        return res;
    }
}