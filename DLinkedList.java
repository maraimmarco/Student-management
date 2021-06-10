/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Mariam
 */
public class DLinkedList {
    static Node Head = null;
    static Node Tail = null;
    static Node CreateNode(String name, int ID , int age , int Level, int Hours , double Gpa , String Major){
        Node node = new Node();
        if(node != null){
            node.ID = ID;
            node.age = age;
            node.Level = Level;
            node.Gpa = Gpa;
            node.Hours = Hours;
            node.name = name;
            node.Major = Major;
            node.Prev = null;
            node.Next = null;
        }
        return node;
    }

    public static boolean AddNode(String name, int ID , int age ,int Level, int Hours , double Gpa , String Major) {
        boolean retval = false;
        Node node = CreateNode(name ,ID , age , Level ,Hours ,Gpa ,Major);
        if(node != null){
            if(Head == null){
                Head = Tail = node;
            }
            else{
                Tail.Next = node;
                node.Prev = Tail;
                Tail = node;
            }
            retval = true;
        }
        return retval;
    }   

    public static String SearchNode(String name, int ID , int age , int Level, int Hours , double Gpa , String Major){
        String found = "not exists";
        Node node;
        node = Head;
        while(node != null){
        if(node.name == name && node.ID == ID && node.age == age && node.Level == Level && node.Hours == Hours  && node.Gpa == Gpa && node.Major == Major){
            found = "exists";
        }

        node = node.Next;
        }
        System.out.println("This Node "+found);
        return found;
    }
    public static Node SearchNodeId(int ID){ 
        Node node;
        node = Head;
        while(node != null && node.ID != ID){
        node = node.Next;
        }
        return node;
    }
    public static Node SearchNodeName(String name){ 
        Node node;
        node = Head;
        while(node != null && node.name != name){
        node = node.Next;
        }
        return node;
    }
    public void Tostring(Node node){
        if(node !=null){
            System.out.println("noame:" + node.name +"\t id:"+node.ID +" age:"+ node.age +" Level:"+ node.Level +" Hours:"+ node.Hours +" GPA:"+ node.Gpa +" Major:"+ node.Major) ;
        }else{
            System.out.println("This Node not exists ");
        }

    }
    public static boolean InsertNode(String name, int ID , int age , int Level, int Hours , double Gpa , String Major){
        boolean retval = false;
        Node node;
        node = CreateNode(name ,ID , age ,Level ,Hours ,Gpa ,Major);
        if(node != null){
            if(Head == null){
                Head = Tail = node;
            }else {
                if(ID == 0){
                    node.Prev = Head;
                    Head.Prev = node;
                    Head = node;
                    retval = true;
                }
                else{
                   Node temp;
                   temp =  Head;
                   for(int i = 0 ; i < ID - 1 && temp != null ; i++){
                       temp = temp.Next;
                   }
                   if(temp == null || temp == Tail){
                       Tail.Next = node;
                       node.Prev = Tail;
                       Tail = node;
                   }
                   else{
                       temp.Next.Prev = node;
                       node.Next = temp.Next;
                       node.Prev = temp;
                       temp.Next = node;
                   }
                }
            }
                retval = true;
        }
        return retval;
    }public static boolean InsertNodeLoc(String name, int ID , int age , int Level, int Hours , double Gpa , String Major,int loc){
        boolean retval = false;
        Node node;
        node = CreateNode(name ,ID , age ,Level ,Hours ,Gpa ,Major);
        if(node != null){
            if(Head == null){
                Head = Tail = node;
                retval=true;
            }else {
                if(loc == 0){
                    node.Prev = Head;
                    Head.Prev = node;
                    Head = node;
                    retval = true;
                }
                else{
                   Node temp;
                   temp =  Head;
                   for(int i = 0 ; i < loc - 1 && temp != null ; i++){
                       temp = temp.Next;
                   }
                   if(temp == null || temp == Tail){
                       Tail.Next = node;
                       node.Prev = Tail;
                       Tail = node;
                   }
                   else{
                       temp.Next.Prev = node;
                       node.Next = temp.Next;
                       node.Prev = temp;
                       temp.Next = node;
                   }
                }
            }
                retval = true;
        }
        return retval;
    }
    public static boolean DeleteNode(int loc){
        boolean retval = false;
        if(Head != null){
            if(loc == 0){
                if(Head == Tail){
                    Head = Tail = null;
                }
                else{
                    Head = Head.Next;
                    Head.Prev = null;
                }
                retval = true;
            }
            else{
                Node Current;
                Current = Head;
                for(int i = 0; i<loc && Current != null ; i++){
                    Current  = Current.Next;
                }
                if(Current !=  null){
                    if(Current == Tail){
                        Tail = Tail.Prev;
                        Tail.Next = null;

                    }
                    else{
                        Current.Prev.Next = Current.Next;
                        Current.Next.Prev = Current.Prev;
                    }
                    retval = true;
                }
            }
        }
        return retval;
    }
    public static void DeleteList(){
        Node node;
        while(Head != null){
            node = Head;
            Head = Head.Next;
            Head.Prev = null;
        }
        Tail = null;
    }
    public void DisplayAllElements() {
        int i=0;
        if (Head == null) {
            System.out.println("Empty list");
        } else {
            Node node = Head;
            while (node != null) {
                
                System.out.println(i+" = noame:" + node.name +"\t id:"+node.ID +" age:"+ node.age +" Level:"+ node.Level +" Hours:"+ node.Hours +" GPA:"+ node.Gpa +" Major:"+ node.Major);
                node = node.Next;
                i++;
            }
        }
    }
    public static void DisplayStudentbyID(int ID){
        Node node;
        node = Head;
        while(node != null){

            if(node.ID == ID){
                System.out.println("noame:" + node.name +"\t id:"+node.ID +" age:"+ node.age +" Level:"+ node.Level +" Hours:"+ node.Hours +" GPA:"+ node.Gpa +" Major:"+ node.Major);
                break;
            }
            node = node.Next;
        }
    }
    public static void DiplayStudentsInLevel(int Level){
        Node node;
        node = Head;
        while(node != null){
            if (Level > 4 || Level <= 0){
                System.out.println("This Year doesn't exist");
                break;
            }
            else if(node.Level == Level){
                System.out.println("noame:" + node.name +"\t id:"+node.ID +" age:"+ node.age +" Level:"+ node.Level +" Hours:"+ node.Hours +" GPA:"+ node.Gpa +" Major:"+ node.Major);

            }

            node = node.Next;
        }
    }
        public static void DiplayStudentsInMajor(String Major){
        Node node;
        node = Head;
        while(node != null){
            if(node.Major == Major){
                System.out.println("noame:" + node.name +"\t id:"+node.ID +" age:"+ node.age +" Level:"+ node.Level +" Hours:"+ node.Hours +" GPA:"+ node.Gpa +" Major:"+ node.Major);

            }

            node = node.Next;
        }
    }
    public static void Update(int ID, int age ,int Level, int Hours , double Gpa , String Major){
        Node node;
        node = Head;
        while(node != null){
            if(node.ID == ID){
                node.Level = Level;
                node.Gpa = Gpa;
                node.Hours = Hours;
                node.age = age;
                node.Major = Major;

                break;
            }
            node = node.Next;
        }
    }
    public static void UpdateID(int ID , double Gpa ){
        Node node;
        node = Head;
        while(node != null){
            if(node.ID == ID){
                node.Gpa = Gpa;

                break;
            }
            node = node.Next;
        }
    }
    public static void UpdateMajor(int ID , String Major ){
        Node node;
        node = Head;
        while(node != null){
            if(node.ID == ID){
                node.Major = Major;

                break;
            }
            node = node.Next;
        }
    }
    public static void UpdateHours(int ID , int Hours ){
        Node node;
        node = Head;
        while(node != null){
            if(node.ID == ID){
                node.Hours = Hours;

                break;
            }
            node = node.Next;
        }
    }
    public double maxGpaInLevel(int Level){
        double maxgpa = 0;
        Node node = Head;

        while(node != null){
            if(node.Level == Level){
              if(node.Gpa > maxgpa){
                    maxgpa = node.Gpa;


                }
            }
            node = node.Next;

        }
     System.out.println("max Gpa In Level "+Level+": "+maxgpa);
      return  maxgpa;


    }

    public double maxGpaInMajor(String Major){
        double maxgpa = 0;
        Node node = Head;

        while(node != null){
            if(node.Major == Major){
              if(node.Gpa > maxgpa){
                    maxgpa = node.Gpa;


                }
            }
            node = node.Next;

        }
     System.out.println("max Gpa In Major "+Major+": "+maxgpa);
      return  maxgpa;

    }



     public double minGpaInMajor(String Major){
        double mingpa = 4.0;
        Node node = Head;
        while(node != null){
            if(node.Major == Major){
                if(node.Gpa <= mingpa){
                    mingpa = node.Gpa;

                }
            }
        node = node.Next;
        }
        System.out.println("min Gpa In Major "+Major+": "+mingpa);
        return mingpa;
        }

     public double minGpaInLevel(int Level){
        double mingpa = 4.1;

        Node node;
        node = Head;
        while(node != null){
            if(node.Level == Level){
                if(node.Gpa < mingpa){
                    mingpa = node.Gpa;

                }
            }
        node = node.Next;
        }
        System.out.println("min Gpa In Level "+Level+": "+mingpa);
        return mingpa;
    }

     public double averageGpaInLevel(int Level){
        double count = 0;
        double sum = 0;
        double avg = 0;
        Node node = Head;
        while(node != null){
            if(node.Level == Level){
                sum = sum + node.Gpa;
                count++;
                avg = sum/count;

            }
            node = node.Next;
        }
        System.out.println("average Gpa In Level "+Level+": "+avg);
        return avg;
    }

     public double averageGpaInMajor(String Major){
        double count = 0;
        double sum = 0;
        double avg = 0;
        Node node = Head;
        while(node != null){
            if(node.Major == Major){
                sum = sum + node.Gpa;
                count++;
                avg = sum/count;

            }
            node = node.Next;
        }
         System.out.println("average Gpa In Major"+Major+": "+avg);
        return avg;
    }


    public static void SortStudentsInLevel(int Level){
      Node current = Head;
      Node index = null;
      int temp;
      int age;
      double gpa;
      int hours;
      String major;
      String name;
      for(current = Head; current.Next != null; current = current.Next){
          if(current.Level != Level){
              continue;
          }
          for(index = current.Next; index != null; index = index.Next){
              if(index.Level != Level){
              continue;
          }
              if(current.ID > index.ID){
                  temp = current.ID;
                  current.ID = index.ID;
                  index.ID = temp;

                  age = current.age;
                  current.age = index.age;
                  index.age = age;

                  gpa = current.Gpa; 
                  current.Gpa = index.Gpa;
                  index.Gpa = gpa;

                 hours = current.Hours; 
                  current.Hours = index.Hours;
                  index.Hours = hours;

                  major = current.Major;  
                  current.Major = index.Major;
                  index.Major = major;

                  name = current.name;
                  current.name = index.name;
                  index.name = name;


              }

          }
      }
    }
    public static void SortStudentsInMajor(String Major){
      Node current = Head;
      Node index = null;
      int temp;
      int age;
      double gpa;
      int hours;
      int level;
      String name;
      for(current = Head; current.Next != null; current = current.Next){
          if(current.Major != Major){
              continue;
          }
          for(index = current.Next; index != null; index = index.Next){
              if(index.Major != Major){
              continue;
          }
              if(current.ID > index.ID){
                  temp = current.ID;
                  current.ID = index.ID;
                  index.ID = temp;

                  age = current.age;
                  current.age = index.age;
                  index.age = age;

                  gpa = current.Gpa; 
                  current.Gpa = index.Gpa;
                  index.Gpa = gpa;

                  hours = current.Hours; 
                  current.Hours = index.Hours;
                  index.Hours = hours;

                  level = current.Level;  
                  current.Level = index.Level;
                  index.Level = level;

                  name = current.name;
                  current.name = index.name;
                  index.name = name;


              }

          }
      }
    }
    public static void SortGpaInMajor(String Major){
      Node current = Head;
      Node index = null;
      int temp;
      int age;
      double gpa;
      int hours;
      int level;
      String name;
      for(current = Head; current.Next != null; current = current.Next){
          if(current.Major != Major){
              continue;
          }
          for(index = current.Next; index != null; index = index.Next){
              if(index.Major != Major){
              continue;
          }
              if(current.Gpa > index.Gpa){
                  temp = current.ID;
                  current.ID = index.ID;
                  index.ID = temp;

                  age = current.age;
                  current.age = index.age;
                  index.age = age;

                  gpa = current.Gpa; 
                  current.Gpa = index.Gpa;
                  index.Gpa = gpa;

                  hours = current.Hours; 
                  current.Hours = index.Hours;
                  index.Hours = hours;

                  level = current.Level;  
                  current.Level = index.Level;
                  index.Level = level;

                  name = current.name;
                  current.name = index.name;
                  index.name = name;

              }
          }
      }
    }
}
