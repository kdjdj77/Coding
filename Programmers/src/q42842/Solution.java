package q42842;

/**/

class Solution {
    public int[] solution(int brown, int yellow) {
        for(int height = 1; height <= Math.sqrt(yellow); height++) {
        	if (yellow % height != 0) continue;
        	
        	int width = yellow / height;
        	int tmp = width*2 + height*2 + 4;
        	if (tmp == brown) return new int[] {width+2, height+2};
        }
    	return new int[] {};
    }
}