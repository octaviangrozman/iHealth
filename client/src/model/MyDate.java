package model;
import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MyDate implements Serializable
{
   private int day,month, year;
   GregorianCalendar now = new GregorianCalendar();
   
   public MyDate(int day, int month, int year)
   {
      setYear(year);
      setMonth(month);
      setDay(day);
   }
   public MyDate()
   {
      this.day = now.get(Calendar.DAY_OF_MONTH);
      this.month = now.get(Calendar.MONTH)+1;
      this.year = now.get(Calendar.YEAR);
   }
   public void MyDateDB()
   {
	  this.month--;
	  this.year = this.year-1900;
   }
   public MyDate castToDate(Date d)
   {
	   this.year = d.getYear()+1900;
	   this.month = d.getMonth()+1;
	   this.day = d.getDate();
	   return this;
   }
   public int getDay()
   {
      return day;
   }
   public void setDay(int day)
   {
      if(day > numberOfDaysInMonth(this.month))
      {
         this.day = numberOfDaysInMonth(this.month);
      }
      else if(day < 0)
      {
         this.day = 1;
      }
      else
      {
         this.day = day;
      }
   }
   public int getMonth()
   {
      return month;
   }
   public void setMonth(int month)
   {
      if(month > 12)
      {
         this.month = 12;
      }
      else if(month < 0)
      {
         this.month = 1;
      }
      else
      {
         this.month = month;
      }
   }
   public int getYear()
   {
      return year;
   }
   public void setYear(int year)
   {
      if(year < 0)
      {
         this.year = now.get(Calendar.YEAR);
      }
      else
      {
         this.year = year;
      }
   }
   
    public int numberOfDaysInMonth(int month)
    {
       int days = 0;
       switch(month)
       {
          case 1: case 3: case 5: case 7: case 8: case 10: case 12: days = 31;
          break;
          case 4: case 6: case 9: case 11: days = 30;
          break;
          case 2:
          if(isLeapYear(this.year))
          {
             days = 29;
          }
          else
          {
             days = 28;
          }
          break;
          default: days = 0;
          break;
       }
       return days;
    }
    public boolean isLeapYear(int year)
    {
       if(((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))
       {
          return true;
       }
       else
       {
          return false;
       }
    }
    public void stepForward(int days)
    {
       for(int i = 0; i < days; i++)
       {
          stepForwardOneDay();
       }
    }
    /**
    * This method steps the MyDate object forward with one day. It is also used in the Driver's refreshSchedule method.
    */
   public void stepForwardOneDay()
    {
       this.day ++;
       if(this.day > numberOfDaysInMonth(this.month))
       {
          this.month ++;
          this.day = 1;
       }
       if(this.month > 12)
       {
          this.year++;
          this.month = 1;
       }
    }
    public boolean equals(Object obj)
    {
       if(!(obj instanceof MyDate))
       {
          return false;
       }
       else
       {
          MyDate other = (MyDate) obj;
          return(this.day == other.day && this.month == other.month && this.year == other.year);
       }
    }
    public String toString()
    {
       String all;
       all = String.format("%02d/%02d/%04d", this.day,this.month,this.year);
       return all;
    }
    public boolean isBefore(MyDate date2)
	   {
    	if(this.equals(date2))
    	{
    		return false;
    	}
		   if(this.getYear() == date2.getYear())
		   {
			   if(this.getMonth() < date2.getMonth())
			   {
				   return true;
			   }
			   else if(this.getMonth() == date2.getMonth())
			   {
				   if(this.getDay() <= date2.getDay())
				   {
					   return true;
				   }
			   }
			   else
			   {
				   return false;
			   }
		   }
		   else if(this.getYear() < date2.getYear())
		   {
			   return true;
		   }
		   return false;
	   }
	   public boolean isAfter(MyDate date2)
	   {
		   if(this.equals(date2))
	    	{
	    		return false;
	    	}
		   if(this.getYear() == date2.getYear())
		   {
			   if(this.getMonth() > date2.getMonth())
			   {
				   return true;
			   }
			   else if(this.getMonth() == date2.getMonth())
			   {
				   if(this.getDay() >= date2.getDay())
				   {
					   return true;
				   }
			   }
			   else
			   {
				   return false;
			   }
		   }
		   else if(this.getYear() > date2.getYear())
		   {
			   return true;
		   }
		   return false;
	   }
    public MyDate copy()
    {
       MyDate copy = new MyDate(this.day,this.month,this.year);
       return copy;
    }
      
}
