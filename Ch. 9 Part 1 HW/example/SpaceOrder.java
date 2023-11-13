package example;

public class SpaceOrder {

   protected boolean special;
   protected boolean accept=false;

   public SpaceOrder(boolean isSpecial) {
      special = isSpecial;
   }

   public boolean getSpecial() {
      return this.special;
   }

   public boolean acceptOrder(int space) {
      boolean status=true;
      this.accept = false;
      if (space<=0)
         status=false;
      else if (space<=1024 && (space>=16 || this.special))
         this.accept = true;
      return status;
   }

   public boolean getAccept() {
      return this.accept;
   }

}
