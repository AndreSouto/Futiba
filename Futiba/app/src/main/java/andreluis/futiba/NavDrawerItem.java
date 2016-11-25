package andreluis.futiba;

import android.content.res.TypedArray;

/**
 * Created by andreluis on 07/11/16.
 */
public class NavDrawerItem {

    private TypedArray array;
    private String title;
    private int icon;
    private String count = "0";
    // boolean to set visibility of the counter
    private boolean isCounterVisible = false;

    //construtor padrao
    //public NavDrawerItem(){}

    public NavDrawerItem(int icon){
        //this.title = title;
        this.icon = icon;
        //this.array = array;
    }

    //  public NavDrawerItem(String title, boolean isCounterVisible, String count){
    //      this.title = title;
    //     //this.icon = icon;
    //      this.isCounterVisible = isCounterVisible;
    //      this.count = count;
    //  }

    public TypedArray getArray() {
        return this.array;
    }

    public String getTitle(){
        return this.title;
    }

    public int getIcon(){
        return this.icon;
    }

    public String getCount(){
        return this.count;
    }

    public boolean getCounterVisibility(){
        return this.isCounterVisible;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setIcon(int icon){
        this.icon = icon;
    }

    public void setCount(String count){
        this.count = count;
    }

    public void setCounterVisibility(boolean isCounterVisible){
        this.isCounterVisible = isCounterVisible;
    }
}