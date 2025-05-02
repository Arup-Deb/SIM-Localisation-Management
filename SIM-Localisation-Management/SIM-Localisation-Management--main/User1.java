package sim;
import java.util.Scanner;

public class User1 implements User {
	private int userId;
	private String userName;
	private String sim;
	private String region;
	private double plan;
	Scanner sc=new Scanner(System.in);
	
	public User1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User1(int userId, String userName, String sim, String region, double plan) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.sim = sim;
		this.region = region;
		this.plan = plan;
	}
	public void createAccount() {
		System.out.println("enter id");
		this.userId = sc.nextInt();
		System.out.println("enter name");
		this.userName = sc.next();
		System.out.println("enter sim");
		this.sim = sc.next();
		System.out.println("enter region");
		this.region = sc.next();
		System.out.println("enter plan");
		this.plan = sc.nextDouble();
	}
	@Override
	public String toString() {
		return "User1 [userId=" + userId + ", userName=" + userName + ", sim=" + sim + ", region=" + region
				+ ", addonPlan=" + plan + "]";
	}
	public void display() {
		System.out.println("User ID:"+userId);
		System.out.println("User name:"+userName);
		System.out.println("SIM:"+sim);
		System.out.println("Region:"+region);
		System.out.println("Plan Add on :"+plan);
	}
	@Override
	public void planAddon(double addonPlan) {
		this.plan+=addonPlan;
		System.out.println("New plan is :"+this.plan);
		
	}
	@Override
	public void transfersim(String newRegion) {
		this.region=newRegion;
		System.out.println("SIM transfered to :"+newRegion);
		
	}
	
	@Override
	public void simport(String newsim) {
		this.sim=newsim;
		System.out.println("SIM transfered to :"+newsim);
		
		
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getSim() {
		return sim;
	}
	public void setSim(String sim) {
		this.sim = sim;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public double getPlan() {
		return plan;
	}
	public void setPlan(double plan) {
		this.plan = plan;
	}
	public Scanner getSc() {
		return sc;
	}
	public void setSc(Scanner sc) {
		this.sc = sc;
	}
	
	
	
	
}

