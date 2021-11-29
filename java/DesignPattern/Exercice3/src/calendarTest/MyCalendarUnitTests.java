package calendarTest;

import calendar.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.*;

public class MyCalendarUnitTests{
  private CalendarView v;
  private BirthdayView b;
  private MyCalendar cal;
  private ArrayList<Event> viewList,calList;
  @BeforeEach
  public void initialize(){
    v=new CalendarView("copy of Tom's calendar");
    b=new BirthdayView("copy of Tom's birthday calendar");
    cal=new MyCalendar(v,"Tom's calendar");
    try{
      cal.attach(b);
    }catch(MaximalSizeException e){
      e.printStackTrace();
    }
    cal.addEvent(new Event(EventType.Birthday," John ",13,1,2013));
    viewList=v.getEvents();
    calList=cal.getEvents();
  }
  @Test
  public void test1(){
    for(Event e:calList)
      assertTrue(viewList.contains(e));
  }
  @Test
  public void test2() throws MinimalSizeException{
    cal.detach(v);
    cal.detach(v);
  }
  @Test
  public void test3(){
    assertThrows(MinimalSizeException.class,()->{ cal.detach(v); });
  }
}
