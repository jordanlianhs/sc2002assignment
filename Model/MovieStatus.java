package Model;

public enum MovieStatus {
    COMINGSOON, 
    PREVIEW, 
    NOWSHOWING,
    ENDOFSHOWING 
} 

// System.out.println(MovieStatus.COMINGSOON.toString());

// public enum MovieStatus {
//     COMINGSOON {public String toString() {return "Coming Soon";}}, 
//     PREVIEW {public String toString() {return "Preview";}}, 
//     NOWSHOWING {public String toString() {return "Now Showing";}}, 
//     ENDOFSHOWING {public String toString() {return "End Of Showing";}}
// } 