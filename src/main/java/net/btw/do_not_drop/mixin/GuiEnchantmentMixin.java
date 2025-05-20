package net.btw.do_not_drop.mixin;

import net.btw.do_not_drop.interfaces.AutoGetBack;
import net.minecraft.src.GuiEnchantment;
import org.spongepowered.asm.mixin.Mixin;

import java.util.List;

@Mixin(GuiEnchantment.class)
public class GuiEnchantmentMixin implements AutoGetBack {
    @Override
    public List<Integer> DoNotDrop$GetBackIndexes() {
        return List.of(0);
    }
}
