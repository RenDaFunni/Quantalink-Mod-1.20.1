package net.renmod.quantalink.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.renmod.quantalink.Quantalink;

import java.util.List;

public class QLFeaturePlacement {
    public static final ResourceKey<PlacedFeature> HarmonicQuartzPlacedKey = registerKey("harmonic_quartz_placed");
    public static final ResourceKey<PlacedFeature> NetherHarmonicQuartzPlacedKey = registerKey("nether_harmonic_quartz_placed");
    public static final ResourceKey<PlacedFeature> EndHarmonicQuartzPlacedKey = registerKey("end_harmonic_quartz_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, HarmonicQuartzPlacedKey, configuredFeatures.getOrThrow(QLConfigFeatures.OverworldHarmonicQuartzOreKey),
                QLOreGeneration.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        register(context, NetherHarmonicQuartzPlacedKey, configuredFeatures.getOrThrow(QLConfigFeatures.NetherHarmonicQuartzOreKey),
                QLOreGeneration.commonOrePlacement(6,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(256))));

        register(context, EndHarmonicQuartzPlacedKey, configuredFeatures.getOrThrow(QLConfigFeatures.EndHarmonicQuartzOreKey),
                QLOreGeneration.commonOrePlacement(3,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(256))));
    }


    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Quantalink.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
