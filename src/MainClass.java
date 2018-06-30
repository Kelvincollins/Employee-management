
class MainClass{
 
public static Helper helper= new Helper();
public static void main(String[] args){
	int i=1;
	helper.insertEmployee(29441344, "collins", "Cheruiyot", "Developer", 40000, "4878787", "0722154669");
		
	helper.editEmployee(36784396 , 600000);

	helper.deleteEmployee(40000);
		
	
    //helper.showDetails();
    helper.showEmployee(36784396);
}


}