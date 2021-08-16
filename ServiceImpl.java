package com.lti.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.BusDetails;
import com.lti.entity.BusRoute;
import com.lti.entity.BusType;
import com.lti.entity.Registration;
import com.lti.entity.Reservation;
import com.lti.exception.BusServiceException;
import com.lti.repo.Repository;
import com.sun.mail.util.MailConnectException;

@Service
public class ServiceImpl implements ProjectService {

	@Autowired
	Repository repo;
	
	
	
	@Override
	public void addBusType(BusType newBus) {
		try {
			repo.addBusType(newBus);
		}catch (Exception e) {
			throw new BusServiceException("Invalid entry,Bus cannot be added!!");
		}
		
	}

	@Override
	public void updateBusStatus(String busName, String busStatus) {
		try {
			repo.updateBusStatus(busName, busStatus);
		} catch (Exception e) {
			throw new BusServiceException("Invalid entry, Bus Status cannot be updated ");
		}
	}

	@Override
	public void deleteBus(String busName) {
		try {
			repo.deleteBus(busName);
		} catch (Exception e) {
			throw new BusServiceException("Invalid entry, Bus Status cannot be deleted ");
		}
	}

	@Override
	public BusType getBusType(String busName) {
		try {
			return repo.getBusType(busName);
		} catch (Exception e) {
			throw new BusServiceException("Not Found!!");
		}
	}

	@Override
	public void addBusDetails(BusDetails busObj) {
		try {
			repo.addBusDetails(busObj);
		} catch (Exception e) {
			throw new BusServiceException("Invalid entry, Bus Details cannot be added!! ");
		}
	}

	@Override
	public void deleteBusDetails(int routeNo) {
		try {
			repo.deleteBusDetails(routeNo);
		} catch (Exception e) {
			throw new BusServiceException("Invalid entry, Bus Details cannot be deleted ");
		}
	}
	
	@Override
	public void updateBusDetails(int routeNo, String busName) {
		try {
			repo.updateBusDetails(routeNo, busName);
		} catch (Exception e) {
			throw new BusServiceException("Invalid entry, Bus  cannot be updated ");
		}
	}

	@Override
	public BusDetails getBus(int routeNo) {
		try {
			return repo.getBus(routeNo);
		} catch (Exception e) {
			throw new BusServiceException("Bus NOT FOUND!!");
		}
	}

	@Override
	public void addRoute(BusRoute newRoute) {
		try {
			repo.addRoute(newRoute);
		} catch (Exception e) {
			throw new BusServiceException("Invalid entry, Route cannot be added ");
		}
	}

	@Override
	public void deleteRoute(int pathNo) {
		try {
			repo.deleteRoute(pathNo);
		} catch (Exception e) {
			throw new BusServiceException("Invalid entry, Route cannot be deleted ");
		}
	}

	@Override
	public List<String[]> searchBus(String src, String dest, String fromTime, String toTime, String typeOfUser) {
		// return pathNo src dest routeNo distance startTime reachedTime fare busNo busName bustYpe busStatus
		try {
			List<String[]> allBus = repo.searchBus(src, dest);
			List<String[]> allBuses = new ArrayList<String[]>();
			int checkhr1=0,checkmin1=0;
			int checkhr2=0,checkmin2=0;
			                                   //05:40 to 06:00  
			for(int i=0;i<2;i++) {
				int k=1;
				checkhr1 += ((int)fromTime.charAt(i)-48)*Math.pow(10, k-i);  //0+10^2 + 5+10^1
				checkmin1 += ((int)fromTime.charAt(i+3)-48)*Math.pow(10, k-i);  //4+10^2 + 0+10^1
				checkhr2 += ((int)toTime.charAt(i)-48)*Math.pow(10, k-i);  //0+10^2 + 6+10^1
				checkmin2 += ((int)toTime.charAt(i+3)-48)*Math.pow(10,k- i);  //0+10^2 + 0+10^1
			}
			
			for(String[] bus:allBus) {
				String arrivalTime = bus[5];//05:30   05:40 to 06:00
				int hrbus=0;
				int minbus=0;
				for(int i=0;i<2;i++) {
					int k=1;
					hrbus += ((int)arrivalTime.charAt(i)-48)*Math.pow(10, k-i);  //0+10^2 + 5+10^1
					minbus += ((int)arrivalTime.charAt(i+3)-48)*Math.pow(10, k-i);  //3+10^2 + 0+10^1
				}
				if(hrbus>checkhr1 && hrbus<=checkhr2) {
					if(typeOfUser.equals("unauthorized") && bus[10].equals("Driverless")) {
						//(no need to add bus to the list);
					}else if(typeOfUser.equals("unauthorized") && bus[10].equals("Driver")) {
						allBuses.add(bus);
					}else {
						allBuses.add(bus);
					}
					
				}else if(hrbus==checkhr1) {
					if(minbus>=checkmin1 && minbus<=checkmin2) {
						if(typeOfUser.equals("unauthorized") && bus[10].equals("Driverless")) {
							//(no need to add bus to the list);
						}else if(typeOfUser.equals("unauthorized") && bus[10].equals("Driver")) {
							allBuses.add(bus);
						}else {
							allBuses.add(bus);
						}
					}else {
						//remove bus from busList (no need to add bus to the list)
					}
				}else {
					//remove bus from busList (no need to add bus to the list)
				}
			}
			if(allBuses.size()==0) {                                            
				throw new BusServiceException("No Bus Available for source :" + src +" and destination : " + dest);
			}
			return allBuses;
		} catch (Exception e) {
			throw new BusServiceException("Invalid entry, no buses are available for source :" + src +" and destination : " + dest);
		}
	}

	@Override
	public BusRoute getRouteDetails(int pathNo) {
		try {
			return repo.getRouteDetails(pathNo);
		} catch (Exception e) {
			throw new BusServiceException("Route Not available!!");
		}
	}
	
	@Override
	public void addUnAuthorizedUser(Reservation res, String Email, String PhoneNo) {
		try {
			repo.addUnAuthorizedUser(res, Email, PhoneNo);
		} catch (Exception e) {
			throw new BusServiceException("Invalid entry, Unauthorized user details cannot be added !!");
		}
	}

	@Override
	public void addRegistration(Registration newRegister) {
		try {
			repo.addRegistration(newRegister);
			String registerInfo= "Hello "+ newRegister.getFirstName() +", Your registration is successful!!!";
			sendMail(registerInfo, newRegister.getEmail());
		} catch (Exception e) {
			throw new BusServiceException("User already registred!!");
		}
	}

	@Override
	public void updateBookedTicket(String email, int noOfTicket) {
		try {
			repo.updateBookedTicket(email, noOfTicket);
		} catch (Exception e) {
			throw new BusServiceException("Cannot update booked ticket!!");
		}
	}

	@Override
	public double getWallet(String email) {
		try {
			return repo.getWallet(email);
		} catch (Exception e) {
			throw new BusServiceException(" User account not found, Cannot fetch wallet");
		}
	}

	@Override
	public void updateWallet(String email, double amount) {  
		try {
			double amt = repo.getWallet(email);
			amt = amt + amount;
			if(amt>=0) {
				repo.updateWallet(email, amount);
			}else {
				 throw new BusServiceException("Your wallet amount is less than zero!!");
				//Add money to your wallet, your wallet money is less
			}
		} catch (Exception e) {
			throw new BusServiceException("Your wallet amount is less than zero!!");
		}
		
	}

	@Override
	public void updateUserDetails(String email, Date dob, String gender) {
		try {
			repo.updateUserDetails(email, dob, gender);
		} catch (Exception e) {
			throw new BusServiceException("User account not found,cannot update dob & gender!!");
		}
	}

	@Override
	public void updatePassword(String email, String oldPassword, String newPassword) {
		try {
			Registration resObj = repo.userRegistrationDetails(email);
			String currentPassword = resObj.getPassword();
			if(currentPassword.equals(oldPassword)) {
				repo.forgotPassword(email, newPassword);
			}else {
				throw new BusServiceException("You have entered the wrong password!!");
				//alert password doesnot match, cannot update the password
			}
		} catch (Exception e) {
			throw new BusServiceException("User Not Found!!");
		}
	}

	//need to create a method for email sending to valid user
	
	
	@Override
	public void forgotPassword(String email, String newPassword) {
		try {
			repo.forgotPassword(email, newPassword);
		} catch (Exception e) {
			throw new BusServiceException("User account not found!!");
		}
	}

	@Override
	public List<Registration> noBookedTicket() {
		try {
			return repo.noBookedTicket();
		} catch (Exception e) {
			throw new BusServiceException("No Registered User Found!!");
		}
	}

	@Override
	public String login(String emailId,String password) {
			try {
				Registration resObj = repo.userRegistrationDetails(emailId);
				String currentPassword = repo.login(emailId);
				if(password.equals(currentPassword)) {
					return "Password Matched";
				}else {
					throw new BusServiceException("Password doesn't Matched");
				}
			}catch (Exception e) {
				throw new BusServiceException("User account not found");
			}
	}

	@Override
	public double walletBalance(String email) {
		try {
			return repo.walletBalance(email);
		} catch (Exception e) {
			throw new BusServiceException("User Not Found!!");
		}
	}

	

	@Override
	public void addUserTicket(Registration reg, Reservation res) {
		try {
			repo.addUserTicket(reg, res);
		} catch (Exception e) {
			throw new BusServiceException("User ticket cannot be added in Registered_USER_Table!!");
		}
	}

	@Override
	public List<String[]> allBookedTicket(String emailId) {
		//source dest doj fare  email ticketStatus ticketNo
		try {
			List<String[]> alltickets = repo.allBookedTicket();
			List<String[]> usertickets = new ArrayList<String[]>();
			for(String[] ticket:alltickets) {
				if(ticket[4].equals(emailId) && ticket[5].equals("booked")) {
					usertickets.add(ticket);
				}
			}
			return usertickets;
		} catch (Exception e) {
			throw new BusServiceException("User account not found!!");
		}
	}

	@Override
	public void addReservation(Reservation obj) {
		try {
			repo.addReservation(obj);
		} catch (Exception e) {
			throw new BusServiceException("Ticket cannot be booked!!");
		}
	}

	@Override
	public void update(int ticketNo, String status, Date cancelDate, double refundAmt) {
		try {
			repo.update(ticketNo, status, cancelDate, refundAmt);
		} catch (Exception e) {
			throw new BusServiceException("Cancel ticket cannot be updated!!");
		}
	}

	
	@Override
	public String[] frequentTravelRoute() {
		try {
			return repo.frequentTravelRoute(); //return source destination
		} catch (Exception e) {
			throw new BusServiceException("No Reservation done till yet!!");
		}
	}

	@Override
	public double lastMonthProfit() {
		 try {
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd"); 
			    java.sql.Date sqlDate1 = null;
			    java.sql.Date sqlDate2 = null;
			    Calendar cal = Calendar.getInstance();
			    cal.add(Calendar.MONTH, 0);
			    Date date1 =cal.getTime();
			    cal.add(Calendar.MONTH, -1);
			    Date date2 = cal.getTime();
			    String dt1 =  sdf1.format(date1); 
			    String dt2 =  sdf1.format(date2); 
			    if( !dt1.isEmpty()) {
			         try {
			             java.util.Date normalDate = sdf1.parse(dt1);
			             sqlDate1 = new java.sql.Date(normalDate.getTime());
			         } catch (ParseException e) {
			            
			         }
			     }
			    if( !dt2.isEmpty()) {
			         try {
			             java.util.Date normalDate = sdf1.parse(dt2);
			             sqlDate2 = new java.sql.Date(normalDate.getTime());
			         } catch (ParseException e) {
			            
			         }
			     }
			return repo.lastMonthProfit(sqlDate2, sqlDate1);
		} catch (Exception e) {
			throw new BusServiceException("NO Reservation done till yet!!");
		}
	}

	@Override
	public int mostPreferredBus() {
		try {
			return repo.mostPreferredBus();
		} catch (Exception e) {
			throw new BusServiceException("NO Reservation done till yet!!");
		}
	}

	@Override
	public List<Reservation> dailyBooked(Date date) {
		try {
			return repo.dailyBooked(date);
		} catch (Exception e) {
			throw new BusServiceException("NO Reservation done on Date :"+ date);
		}
	}

	@Override
	public List<Reservation> weeklyBooked(Date date1, Date date2) {
		try {
			return repo.weeklyBooked(date1, date2);
		} catch (Exception e) {
			throw new BusServiceException("NO Reservation done from Date: " + date1 + " to  Date: "+ date2);
		}
	}


	@Override
	public List<Integer> availableSeats(int busNo, String doj,String src, String dest) {
		// TODO Auto-generated method stub
		//doj ticketNo seatno ticketStatus src dest routeNo busNo pathNo
		// search bus return --->  pathNo src dest routeNo distance startTime reachedTime fare busNo busName bustYpe busStatus
		//busNo routeNo doj src dest 
		try {
			HashMap<String,Integer> busStops = new HashMap<String,Integer>();
			busStops.put("Pune", 1);
			busStops.put("Navi Mumbai",2);
			busStops.put("Dombivli", 3);
			busStops.put("Nashik", 4);
			
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
	        java.sql.Date sqlDate = null;
	        String date = doj;
	        if( !date.isEmpty()) {
	             java.util.Date normalDate = sdf1.parse(date);
				 sqlDate = new java.sql.Date(normalDate.getTime());
	         }
			
			
			List<Integer> bookedSeat = new ArrayList<Integer>();
			List<String[]> allSeats = repo.availableSeats();
			int curSrc = busStops.get(src);
			int curDest = busStops.get(dest);
			for(String[] str:allSeats) {
				if(String.valueOf(busNo).equals(str[7]) && str[3].equals("booked") && str[0].equals(doj)) {
					BusRoute busRoute = repo.getRouteDetails(Integer.valueOf(str[8]));
					if(curSrc<curDest) {
						int source = busStops.get(busRoute.getSource());
						int destination = busStops.get(busRoute.getDestination());
						if(curSrc<destination && curDest>source) {
							bookedSeat.add(Integer.valueOf(str[2]));
						}
					}else {
						int source = busStops.get(busRoute.getSource());
						int destination = busStops.get(busRoute.getDestination());
						if(curSrc>destination && curDest<source) {
							bookedSeat.add(Integer.valueOf(str[2]));
						}
					}
				}
			}
			return bookedSeat;
		} catch (Exception e) {
			throw new BusServiceException("NO Seats Available!!");
		}
	}

	@Override
	public String[] searchTicket(int ticketNo) {
		try {
			return repo.searchTicket(ticketNo);
		} catch (Exception e) {
			throw new BusServiceException("Invalid Ticket No!!");
		}
	}

	@Override
	public void cancelTicket(int ticketNo, String email) {
		//source dest doj fare  email ticketStatus ticketNo
		try {
			Registration resObj = repo.userRegistrationDetails(email);
			List<String[]> allTicket =  allBookedTicket(email);
			boolean flag=false;
			for(String[] tic:allTicket) {
				if(tic[6].equals(""+ticketNo) && tic[5].equals("booked")) {
					flag=true;
					break;
				}
			}
			
			
			if(flag) {
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd"); 
			     java.sql.Date sqlDate1 = null;
			     Calendar cal = Calendar.getInstance();
			     cal.add(Calendar.MONTH, 0);
			     Date date1 =cal.getTime();
			     String dt1 =  sdf1.format(date1);
			     if( !dt1.isEmpty()) {
			         try {
			                 java.util.Date normalDate = sdf1.parse(dt1);
			                 sqlDate1 = new java.sql.Date(normalDate.getTime());
			             } catch (ParseException e) {
			                
			             }
			      }
			     Reservation res = repo.getReservation(ticketNo);
					long diff =  res.getDateOfJourney().getTime() - sqlDate1.getTime();
			        long diffDays = diff / (60 * 60 * 1000 * 24);
			        if(diffDays>0) {
			        	repo.cancelTicket(ticketNo,sqlDate1);
			        	double walletAmt = repo.getWallet(email);
			        	walletAmt += res.getNewRoute().getFare();
			        	repo.updateWallet(email, walletAmt);
			        }else {
			        	throw new BusServiceException("Invalid emailId for ticketNo: "+ ticketNo+" or Ticket is already Cancelled");
			        }
			}else {
				throw new BusServiceException("Invalid emailId for ticketNo: "+ ticketNo+" or Ticket is already Cancelled");
			}
			
		}catch(Exception e) {
			throw new BusServiceException("Invalid emailId for ticketNo: "+ ticketNo);
		}
			
	
	}

	@Override
	public Reservation getReservation(int ticketNo) {
		try {
			return repo.getReservation(ticketNo);
		} catch (Exception e) {
			throw new BusServiceException("Invalid Ticket Number, No Reservation Found");
		}
	}

	@Override
	public void printTicket() {
		// TODO Auto-generated method stub
	}

	@Override
	public Registration userRegistrationDetails(String email) {
		try {
			return repo.userRegistrationDetails(email);
		} catch (Exception e) {
			throw new BusServiceException("User Not Found!!");
		}
	}
	
	@Override
	public int getTicketNo() {
		try {
			return repo.getTicketNo();
		}catch(Exception e) {
			throw new BusServiceException("Cannot get Ticket Number");
		}
	}
	@Override
	public void sendMail(String info,String email) {
		String tx= info;
		String fromEmail = "keshavmishra288@gmail.com"; //requires valid gmail id
		String password = "Keshav@123"; // correct password for gmail id
		String toEmail =email;

		String host = "smtp.gmail.com";
		System.out.println("Email Start");
		//tx = "from \n"+fromEmail+"\n\n"+tx;
		Properties props = new Properties();

		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		Session session = Session.getDefaultInstance(props,
		        new javax.mail.Authenticator() {
		            protected PasswordAuthentication getPasswordAuthentication() {
		                return new PasswordAuthentication(fromEmail, password);
		            }
		        });


		try {
		    MimeMessage message = new MimeMessage(session);
		    message.setFrom(new InternetAddress(fromEmail));
		    message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
		    message.setSubject("Message from Keshav");
		    message.setText(tx);

		    //send the message
		    try {
		        Transport.send(message);
		        System.out.println("message sent successfully...");
		    } catch (MailConnectException e) {
		        System.out.println("NETWORK ERROR");
		        System.out.println("PLEASE CHECK YOUR INTERNET CONNECTION");
		    }
       	}catch (MessagingException e) {
		    e.printStackTrace();
		}
	}
}
