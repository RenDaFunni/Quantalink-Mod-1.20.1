package net.renmod.quantalink.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class LSCPProcedures {
    public static void executeRightClick(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
        if (entity == null)
            return;

        if (entity.isCrouching()) {
            LSCPProcedures.LSCPShiftRightCLick(world, x, y, z, entity, itemstack);
        } else {
            LSCPProcedures.LSCPRightCLick(world, x, y, z, entity, itemstack);
        }
    }
    public static void LSCPShiftRightCLick(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
        entity.sendSystemMessage(Component.literal("Shift-Right Clicked!"));
    }
    public static void LSCPRightCLick(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
        entity.sendSystemMessage(Component.literal("Right Clicked!"));
    }
}
