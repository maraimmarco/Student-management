
package project;


public class ProjectData {

    
    public static void main(String[] args) {
        DLinkedList Student_List = new DLinkedList();
        Student_List.AddNode("Ayman", 5, 18 , 1 , 34, 4.0 ,"ComputerScience");
        Student_List.AddNode("Ahmed", 6 , 18 , 1 , 34 , 3.5 ,"ComputerScience" );  
        Student_List.AddNode("Mina", 1 , 19 , 2 , 66 , 2.0 ,"ComputerScience");
        Student_List.AddNode("Salma", 3 , 18 , 1  , 30, 3.9 ,"ComputerScience");
        Student_List.AddNode("Ayoub", 4 , 21 , 4 , 140 , 3.0 ,"Chemstry");
        Student_List.InsertNode("Aly",2,20,3,75,3.0,"chemistry");
        Student_List.InsertNodeLoc("mohamed",7,20,3,75,3.0,"chemistry",7);
        
        Student_List.DisplayAllElements();
        System.out.println("------------------------");
        Student_List.DeleteNode(0);
        Student_List.DeleteNode(5);
        Student_List.DisplayAllElements();
        System.out.println("------------------------");
        Student_List.DisplayStudentbyID(2);
        System.out.println("------------------------");
        Student_List.DiplayStudentsInLevel(1);
        System.out.println("------------------------");
        Student_List.DiplayStudentsInMajor("ComputerScience");
        System.out.println("------------------------");
        Student_List.Update(2,21,4,120,3.3,"chemistry");
        Student_List.UpdateID(6,3.3);
        Student_List.UpdateHours(4,132);
        Student_List.UpdateMajor(3,"chemistry");
        Student_List.DisplayAllElements();
        System.out.println("------------------------");
        Student_List.maxGpaInLevel(1);
        Student_List.minGpaInLevel(1);
        Student_List.maxGpaInMajor("Chemstry");
        Student_List.minGpaInMajor("Chemstry");
        Student_List.averageGpaInLevel(1);
        Student_List.averageGpaInMajor("Chemstry");
        System.out.println("------------------------");
        Node i= Student_List.SearchNodeId(5);
        Student_List.Tostring(i);
        i= Student_List.SearchNodeId(6);
        Student_List.Tostring(i);
        i= Student_List.SearchNodeName("Aly");
        Student_List.Tostring(i);
        
        Student_List.SearchNode("Ayoub",4,21,4,132,3.0,"Chemstry");
        Student_List.SearchNode("Ayoub",3,21,4,132,3.0,"Chemstry");
        System.out.println("------------------------");
        Student_List.SortGpaInMajor("Chemstry");
        Student_List.DisplayAllElements();
        System.out.println("------------------------");
        Student_List.SortStudentsInLevel(1);
        Student_List.DisplayAllElements();
        System.out.println("------------------------");
        Student_List.SortStudentsInMajor("Chemstry");
        Student_List.DisplayAllElements();
         
         
    }
    
}
