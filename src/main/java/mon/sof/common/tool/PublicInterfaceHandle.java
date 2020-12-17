package mon.sof.common.tool;


import java.util.List;

@FunctionalInterface
public interface PublicInterfaceHandle<T> {
    void edit(List<T> list);
}
