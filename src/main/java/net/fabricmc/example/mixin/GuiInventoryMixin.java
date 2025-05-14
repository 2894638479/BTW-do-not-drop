package net.fabricmc.example.mixin;

import net.fabricmc.example.interfaces.AutoGetBack;
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
