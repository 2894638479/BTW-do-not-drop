package net.btw.do_not_drop.mixin;

import btw.client.gui.CraftingGuiWorkbench;
import net.btw.do_not_drop.interfaces.AutoGetBack;
import org.spongepowered.asm.mixin.Mixin;

import java.util.List;

@Mixin(CraftingGuiWorkbench.class)
public class CraftingGuiWorkbenchMixin implements AutoGetBack {
    @Override
    public List<Integer> DoNotDrop$GetBackIndexes() {
        return List.of(1,2,3,4,5,6,7,8,9);
    }
}
