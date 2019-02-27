package inventory_frames;
/**
 *
 * @author LaptopKo
 */
public interface subject {
    public void register(observer o );
    public void unregister(observer o);
    public void notifyObs();
}
