public class AddAnimalButton extends Button {

private String type; // type of the animal to add
 
public AddAnimalButton(String type, float x, float y, JunglePark park) {
    super(x, y, park);
    this.type = type.toLowerCase();
    this.label = "Add " + type;
}
 
@Override
public void mousePressed() {
  if (isMouseOver()) {
    switch (type) {
      case "tiger":
        processing.listGUI.add(new Tiger(processing));
        break;
      case "deer":
        processing.listGUI.add(new Deer(processing));
        break;
    }
  }
}
}