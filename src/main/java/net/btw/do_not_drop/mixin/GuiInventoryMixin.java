package net.btw.do_not_drop.mixin;

import net.btw.do_not_drop.interfaces.AutoGetBack;
import net.minecraft.src.GuiInventory;
import org.spongepowered.asm.mixin.Mixin;

import java.util.List;

@Mixin(GuiInventory.class)
public class GuiInventoryMixin implements AutoGetBack {
    @Override
    public List<Integer> DoNotDrop$GetBackIndexes() {
        return List.of(1,2,3,4);
    }
}
