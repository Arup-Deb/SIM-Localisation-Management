package sim;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class User1Main {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		List<User1> users=new ArrayList<User1>();
		User1 a=null;
		do
		{
			System.out.println("1:Create Account");
			System.out.println("2:Display All Accounts");
			System.out.println("3:Find Accounts By Id");
			System.out.println("4:Perform Addon");
			System.out.println("5: Region specific user:");
			System.out.println("7:Perform sim transfer");
			System.out.println("8:Perform sim porting");
			System.out.println("9:Exit");
			System.out.println("Enter Your choice");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				a=new User1();
				a.createAccount(); 
				users.add(a);
				System.out.println(users);
				break;
			case 2:
		        users.forEach(user->System.out.println(user));
		        break;
			case 3:
				System.out.println("Enter Account id to search");
				int id=sc.nextInt();
			    users.stream().filter(user->user.getUserId()==id).forEach(user->System.out.println(user));
				break;
			case 4:
				System.out.println("Perform addon.Enter your id: ");
				int idtobeaddon=sc.nextInt();
				Optional<User1>optionalUser=users.stream().filter(user->user.getUserId()==idtobeaddon).findFirst();
				if(optionalUser.isPresent()) {
					User1 user=optionalUser.get();
					System.out.println("Before:"+user);
					System.out.println("Enter the addon amount");
					double addonamount=sc.nextDouble();
					user.planAddon(addonamount);
				}
				else {
					System.out.println(idtobeaddon+"Id not found");
				}
				
				break;
			case 5:
				Map<String,Long>mp=users.stream()
				.collect(Collectors.groupingBy(User1:: getRegion,Collectors.counting()));
				mp.forEach((k,r)->System.out.println("Branch "+k+" has no of users "+ r));
				break;
			case 6:
				Map<String,Long>mp1=users.stream()
				.collect(Collectors.groupingBy(User1:: getSim,Collectors.counting()));
				mp1.forEach((k,r)->System.out.println("Sim "+k+" has no of users "+ r));
				break;
				
			case 7:
				System.out.println("Perform Region change.Enter your Id: ");
				int idtobeswitched=sc.nextInt();
				Optional<User1>optionalUser2=users.stream().filter(user->user.getUserId()==idtobeswitched).findFirst();
				if(optionalUser2.isPresent()) {
					User1 user=optionalUser2.get();
					System.out.println("Before region change details are : "+user);
					System.out.println("Enter the newregion");
					String newR=sc.next();
					user.transfersim(newR);
				}
				else {
					System.out.println(idtobeswitched+"Id not found");
				}
				
				break;
			case 8:
				System.out.println("Perform sim porting. Enter your Id: ");
				int idtobeported=sc.nextInt();
				Optional<User1>optionalUser3=users.stream().filter(user->user.getUserId()==idtobeported).findFirst();
				if(optionalUser3.isPresent()) {
					User1 user=optionalUser3.get();
					System.out.println("Before sim change details are :"+user);
					System.out.println("Enter the newsim");
					String newS=sc.next();
					user.transfersim(newS);
				}
				else {
					System.out.println(idtobeported+"Id not found");
				}
				
				break;
				
				
			case 9:
				System.exit(0);
				
			}
			
			
		}
		while(true);
		
	}
}
