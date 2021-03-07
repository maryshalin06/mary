package application;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Vector;

import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

public class Sorting {

    //This variable defines the size of the GUI, it is usually in the range [0.5, 1.5], you adjust it to fit your display
    double size_scale = 1.5;
    
    /************************************************** Implementation Here: **************************************************/
    
    
    /* This function performs an iteration of merge sort by re-arranging the input array "nums" to a different order according to the stage index "stage_idx" 
     * Attention: this function is NOT an action that completely sorts the "nums" but just represents "one round" of the merge procedure durring merge sort
     * this function is called by another function "mergeSort()", which iteratively run "mergeSortBalls(int stage_idx, int[] nums)(int stage_idx, int[] nums)" 
     * by inputing different iteration index and nums[]. 
     * 
     * Input Parameters: 
     *         stage_idx - the round index of merge sort. It starts from 1 and ends at 4 since there are 16 numbers to be sorted: stage_idx = 1, 2, 3, 4
     *                     when stage_idx the output should be sorted nums
     *                     
     *              nums - the input array of 16 numbers to be sorted. Actually, nums[16] is both the input and output. After the processing, the output should 
     *                     saved back to nums[16] again.
     *                     
     * Triggered by:    This function is called by "mergeSort()", which is triggered when you hit the "M" key.      
     * 
     * Variables to use:   You really don't need to use any variables in this class other than the two input parameters.
     * 
     * */
    void mergeSortIteration(int stage_idx, int[] nums)
    {
    	//Implementation Here...
    	
         
       int v=0;
   	int[][] ar=new int[16][16];
   	for(int i=0;i<nums.length/(int)Math.pow(2,stage_idx);++i) {
   		for(int j=0;j<(int)Math.pow(2,stage_idx);j++) {
   			ar[i][j]=nums[v];
   			v++;
   		}
   	}

   	for(int i=0;i<nums.length/(int)Math.pow(2,stage_idx);++i) {
   		for (int b = 0; b < (int)Math.pow(2,stage_idx)-1; b++) {
               for (int c = 0; c < (int)Math.pow(2,stage_idx)-b-1; c++) {
                   if (ar[i][c] > ar[i][c+1]) 
                   { 
                        
                       int temp = ar[i][c]; 
                       ar[i][c] = ar[i][c+1]; 
                       ar[i][c+1] = temp; 
                     
                   } 
   	}
    }
   }
   	v=0;
   	for(int i=0;i<nums.length/(int)Math.pow(2,stage_idx);++i) {
   		for(int j=0;j<(int)Math.pow(2,stage_idx);j++) {
   			nums[v]=ar[i][j];
   			v++;
   		}
   	} 
    		
    	

    }
    
    
    /* This function is similar to the above mergeSortIteration() function that performs one iteration of Radix Sort
     * Though you can use any container to represent bucket. It is suggested to use the provided "MyQueue" to store the numbers drop to different buckets
     * 
     * 
     * Input Parameters: 
     *         stage_idx - the round index of radix sort. It starts from 1 and ends at 2 since there are 16 numbers to be sorted: stage_idx = 1, 2
     *                     when stage_idx the output should be sorted nums
     *                     
     *              nums - the input array of 16 numbers to be sorted. Actually, nums[16] is both the input and output. After the processing, the output should 
     *                     saved back to nums[16] again.
     *                     
     *                     
     * Triggered by:    This function is called by "radixSort()", which is triggered when you hit the "R" key.
     * 
     * Variables to use:   You really don't need to use any variables in this class other than the two input parameters.
     * 
     * 
     * */
    void radixSortIteration(int stage_idx, int[] nums)
    
    {
    	int buckets[][] = new int [10][nums.length]; //initialise bucket
   
    	int count[]=new int[nums.length];
    	int d=1;
    	for(int i=1;i<stage_idx;++i)
    	{
    		d*=10; //digits 0-9
    		
    	}
    	for(int i=0;i<10;++i)
    		count[i]=0;
    	for(int i=0;i<nums.length;++i)
    	{
    		int r=(nums[i]/d)%10;
    		buckets[r][count[r]]=nums[i];
    		count[r]+=1;
    	}
    	int i=0;
    	for(int k=0;k<10;k++)
    	{
    		for(int j=0;j<count[k];j++)
    		{
    			nums[i]=buckets[k][j];
    			i++;
    		}
    	}
    	
    		
    	
    	
    	
    	
    }
    
    
    

    /************************************************** End of Implementation **************************************************/
    
    
    /************************************************* Read Only below ****************************************************************/

    /* The entry point for merge sort*/
    void mergeSort()
    {
        gc.clearRect(0, 0, 20 * radius, 10 * radius);//clear the ball part
        showBalls(0, numbers);
    	int[] merge_array = new int[16];
    	System.arraycopy( numbers, 0, merge_array, 0, numbers.length );
    	
    	
    	for(int idx = 1; idx < 5; idx++)
    	{
        	
    		mergeSortIteration(idx, merge_array);
    		showBalls(idx, merge_array);
        	showFrame(idx);
        	showArrow(idx);
        	showStageLabel("Merge ", idx);
    	}
    	
    }
    
    

    /*The entry point for radix sort*/
    void radixSort()
    {
    	gc.clearRect(0, 0, 20 * radius, 10 * radius);//clear the ball part
    	showBalls(0, numbers);
    	int[] radix_array = new int[16];
    	System.arraycopy( numbers, 0, radix_array, 0, numbers.length );
    	
    	for(int stage_idx = 1; stage_idx < 3; stage_idx++)
    	{
    		radixSortIteration(stage_idx, radix_array);
        	showBalls(stage_idx, radix_array);
        	showFrame(stage_idx);
        	showArrow(stage_idx);
        	showStageLabel("Radix ", stage_idx);
    	}
    }
    
    
    
    private Point2D pt[] = new Point2D[16];
    // private Canvas canvas;
    private GraphicsContext gc;

    private int radius = (int) (50 * size_scale);
    private int radius_center = (int) (25 * size_scale);
    private int canvas_width = (int) (18 * radius); // canvas width
    private int canvas_height =  (int) (3 * radius); // canvas height
    private Vector<Integer> random_sequence = new Vector<Integer>();
    private Vector<Integer> sorted_sequence = new Vector<Integer>();
    private int numbers[] = new int[16]; // the index of ball
	private SimpleDoubleProperty[] pros = new SimpleDoubleProperty[16];
    int m = 0, n = 0;//use for bubble sort
    double motionTime = 0.2;
    SequentialTransition trans = new SequentialTransition();

    //use map to match index and color
    Paint setColor(int i) {
        Map<Integer, Paint> map = new HashMap<Integer, Paint>();
//        Paint[] colorArray = { Color.RED, Color.BLUE, Color.BLACK, Color.rgb(102, 102, 255),
//                Color.BLUEVIOLET, Color.AQUAMARINE, Color.CHOCOLATE,
//                Color.CADETBLUE, Color.CHARTREUSE, Color.DARKMAGENTA,
//                Color.FIREBRICK, Color.HOTPINK, Color.ROSYBROWN, Color.rgb(255, 153, 51),
//                Color.SLATEGRAY, Color.SEAGREEN };
        
        Paint[] colorArray = { Color.rgb(204, 224, 255), Color.rgb(179, 209, 255), Color.rgb(153, 194, 255), Color.rgb(128, 179, 255),
                Color.rgb(102, 163, 255), Color.rgb(77, 148, 255), Color.rgb(51, 133, 255),
                Color.rgb(26, 117, 255), Color.rgb(0, 102, 255), Color.rgb(0, 92, 230),
                Color.rgb(0, 82, 204), Color.rgb(0, 71, 179), Color.rgb(0, 61, 153), Color.rgb(0, 51, 128),
                Color.rgb(0, 41, 102), Color.rgb(0, 20, 51) };
        Paint colors = colorArray[i];
        map.put(i, colors);
        return colors;
    }

    public Sorting(Canvas canvas, GraphicsContext gc) {
        this.gc = gc;
        for (int i = 0; i < 16; i++) {
            pros[i] = new SimpleDoubleProperty(radius * 1.1 * i + (canvas_width / 2 - 8 * radius) + 10 * size_scale);
            pros[i].addListener(new ChangeListener<Number>() {

                @Override
                public void changed(
                        ObservableValue<? extends Number> observable,
                        Number oldValue, Number newValue) {
                    showBalls(0, numbers);
                }

            });
        }
    }

    public Sorting() {
    }

    //Re-shuffle the balls into different order
    void reshuffleBalls() {
        random_sequence.clear();
        sorted_sequence.clear();


        gc.clearRect(0, 0, 20 * radius, 10 * radius);//clear the ball part
        
        
        Random rand = new Random();

        for (int i = 0; i < 16; i++) {
            int rand_num = rand.nextInt(16);
            int pass = 0;

            while (pass == 0) {
                pass = 1;
                for (int j = 0; j < random_sequence.size(); j++) {
                    if ((int) random_sequence.get(j) == rand_num) {
                        pass = 0;
                        break;
                    }
                }

                if (pass == 0) {
                    rand_num = rand.nextInt(16);
                }
            }
            random_sequence.addElement(rand_num);
            sorted_sequence.addElement(i);

        }
        for (int i = 0; i < 16; i++) {
            numbers[i] = random_sequence.get(i); // the index of ball
        }
        showBalls(0, numbers);
        m = 0;
        n = 0;
    }
   
    
    
    //show the arrow under balls
    void showTriangle(int i,int j){
        
        pt[i] = new Point2D(pros[i].get(), radius);
        gc.setFill(Color.CORNFLOWERBLUE);
        gc.fillPolygon(
            new double[]{pt[i].getX()+radius*0.5, pt[i].getX()+radius*0.4, pt[i].getX()+radius*0.6},
            new double[]{pt[i].getY()+radius,pt[i].getY()+radius*1.4,pt[i].getY()+radius*1.4}, 3);
        pt[j] = new Point2D(pros[j].get(), radius);
        gc.setFill(Color.YELLOWGREEN);
        gc.fillPolygon(
            new double[]{pt[j].getX()+radius*0.5, pt[j].getX()+radius*0.4, pt[j].getX()+radius*0.6},
            new double[]{pt[j].getY()+radius,pt[j].getY()+radius*1.4,pt[j].getY()+radius*1.4}, 3);

    }

    void showBalls(int stage_idx, int[] num_array) {
        for (int i = 0; i < 16; i++) {
            
            pt[i] = new Point2D(pros[i].get(), radius * (1.3 + stage_idx * 2)); // point
                                                        // position
            
            
            
            gc.setFill(setColor(num_array[i])); // set the customed color for specific
                                          // index
            gc.setStroke(Color.BLACK);
            gc.fillOval(pt[i].getX(), pt[i].getY() - radius/2, radius, radius);
            gc.setFill(Color.WHITE); // set the customed color for specific
                                     // index
            gc.fillOval(pt[i].getX() + radius/3.7,
                    pt[i].getY() + radius / 3.7  - radius/2, radius_center, radius_center);
            gc.setFill(Color.BLACK);
            Font font = Font.font("verdana", FontWeight.BOLD, radius / 3);
            gc.setFont(font);

            //make numbers can be shown at the center of balls
            if (num_array[i] <= 9)
                gc.fillText(Integer.toString(num_array[i]),
                        pt[i].getX() + radius / 2.5,
                        pt[i].getY() + radius / 1.6 - radius/2);
            else
                gc.fillText(Integer.toString(num_array[i]),
                        pt[i].getX() + radius / 3.5,
                        pt[i].getY() + radius / 1.6 - radius/2);
        }
    }

    
	void swapBalls(int i, int j) {
		 gc.clearRect(0, 0, canvas_width, canvas_height - radius);//clear the ball part
		
		//(1) Draw all the other balls other than i and j 
		//(2) Generate motion between ball i and ball j
		//(3) Draw all the balls after the swap change between the two balls
		
		
	}
	
	void drawBoundary(int i, int j) //j = i + 1
	{
		
	}

    //handler for bubble sort
    EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {

        public void handle(ActionEvent event) {
            System.out.println(m + " " + n);
            if (m >= 15) {
                return;
            }
            Timeline timeline = new Timeline();
            if (numbers[n] > numbers[n + 1]) {
                int temp = numbers[n];
                numbers[n] = numbers[n + 1];
                numbers[n + 1] = temp;
                gc.clearRect(0, radius*2, canvas_width, radius);//clear arrow part

                SimpleDoubleProperty t = pros[n];
                pros[n] = pros[n + 1];
                pros[n + 1] = t;
                timeline.getKeyFrames()
                        .add(new KeyFrame(Duration.seconds(motionTime), handler,
                                new KeyValue(pros[n], pros[n + 1].get()),
                                new KeyValue(pros[n + 1], pros[n].get())));
                System.out.println(n);
                System.out.println(n + 1);
                System.out.println(Arrays.toString(numbers));
                showTriangle(n,n+1);
            } else {
                timeline.getKeyFrames()
                        .add(new KeyFrame(Duration.seconds(0.01), handler));
            }
            timeline.play();
            n++;
            if (n >= 15 - m) {
                n = 0;
                m++;
            }
        }
    };
	
    
    
    //a simple power function 
    int pow (int a, int b)
    {
        if(b > 0)
        {
        	b--;
        	return a * pow(a, b); 
        }
        else
        {
        	return 1;
        }

    }
  
   /*Draw the arrow for each stage*/
	void showArrow(int idx) {
		Point2D pos = new Point2D(pros[7].get(), radius);
		gc.setFill(Color.GOLD);
		gc.fillPolygon(
				new double[] { pos.getX() + radius * 0.5, pos.getX() + radius * 0.2, pos.getX() + radius * 0.8 },
				new double[] { pos.getY() + radius * (idx * 2 - 0.3), pos.getY() + radius * (2 * idx - 0.8), pos.getY() + radius * (2 * idx - 0.8)}, 3);
	}
  
	
    /*Draw the frame, text, and arrow according to the index*/
    void showFrame(int idx)
    {
    	
    	//Frame's color 
    	gc.setStroke(Color.rgb(20, 20, 20));
    	
    	//Frame's width
    	gc.setLineWidth(2);
    	
    	//Frame's position
    	Point2D start_pos;
    	start_pos = new Point2D(pros[0].get() - radius/4, radius * (0.8 + idx * 2));
    	gc.strokeRoundRect(start_pos.getX(), start_pos.getY(), canvas_width , radius, 20 * size_scale, 20 * size_scale);
    
    	
    	
    	 
    }
    
    /* Draw the stage label for both merge sort and radix sort uses */
    void showStageLabel(String sort_method, int idx)
    {
    	gc.setFill(Color.BLACK);
    	
    	//Calculate label position
    	Point2D start_pos;
    	start_pos = new Point2D(pros[0].get() - radius/4, radius * (0.8 + idx * 2));
    	
    	//Draw Stage Label
        gc.fillText(sort_method + Integer.toString(idx), start_pos.getX() - radius/2, start_pos.getY() - radius/6);
    }
    
    

    
    public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public int getRadius_center() {
		return radius_center;
	}

	public void setRadius_center(int radius_center) {
		this.radius_center = radius_center;
	}

	public int[] getNumbers() {
		return numbers;
	}

	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}

}
