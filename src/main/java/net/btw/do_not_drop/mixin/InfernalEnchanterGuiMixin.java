package net.btw.do_not_drop.mixin;

import btw.client.gui.InfernalEnchanterGui;
import net.btw.do_not_drop.interfaces.AutoGetBack;
import org.spongepowered.asm.mixin.Mixin;

import java.util.List;

@Mixin(InfernalEnchanterGui.class)
public class InfernalEnchanterGuiMixin implements AutoGetBack {
    @Override
    public List<Integer> DoNotDrop$GetBackIndexes() {
        return List.of(0,1);
    }
}
