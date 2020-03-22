// declaration of variables
float xPos;                          // x position of the ball
float yPos;                          // y position of the ball
int diameter;                        //declaration of variable diameter of type integer
float speed; 
float gravity;
Ball[] listofmyballs = new Ball[10]; //declaration of variable of type Ball as part of an array containing only Ball type variables, with type Ball being defined in class_Ball as an collection of charcteristics, resulting in an object; so in the end we have a list of objects
int countdoku = 0;                   //counting variable for filled elemnts of list listofmyballs[]

// set up function
void setup() {
  //frameRate(10);
  size(900, 900); 
  background(0);
  diameter = 70;
  listofmyballs[0] = new Ball(width/2,diameter/2,diameter);  //first element, which is named "listofmyballs[0]", of empty array ,named "listofmyballs[]", is getting filled
}

void mousePressed(){
  if(countdoku < 9){
    countdoku = countdoku + 1;
    listofmyballs[countdoku] = new Ball(mouseX,mouseY,diameter); //next empty element of the list named "listofmyballs[]" is getting filled with an object, which is Ball[]
  } else {
    print("max amount of balls ;-D\n");
  }
};

// draw function
void draw() {
  int i = 0;
  background(0);
  while (i <= countdoku){            //in each draw cycle all already existing elements of the array listofmyballs[] are getting new....
    listofmyballs[i].fallandjump();  // ...positional data....and
    listofmyballs[i].display();      //...are drawn with their new positional data
    i = i + 1;
  }
}
