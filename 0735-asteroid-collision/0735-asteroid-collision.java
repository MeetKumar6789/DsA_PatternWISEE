 class Solution { 
    public int[] asteroidCollision(int[] asteroids) { 
        int n = asteroids.length; 
        Stack<Integer> stack = new Stack<>(); 
        
        for(int i = 0; i < n; i++) { 
            int curr = asteroids[i]; 
            boolean alive = true; 
            
            while(!stack.isEmpty() && stack.peek() > 0 && curr < 0) { 
                int top = stack.peek(); 
                if(Math.abs(top) > Math.abs(curr)) { 
                    alive = false; 
                    break; 
                } else if(Math.abs(top) < Math.abs(curr)) { 
                    stack.pop(); 
                } else { 
                    stack.pop(); 
                    alive = false; 
                    break; 
                } 
            } 
            
            if(alive) { 
                stack.push(curr); 
            } 
        } 
        
        // Convert stack to an array
        int[] result = new int[stack.size()];
        for(int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result; 
    } 
}
