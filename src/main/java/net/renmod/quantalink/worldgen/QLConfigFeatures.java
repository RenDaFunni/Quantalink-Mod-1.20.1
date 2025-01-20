package net.renmod.quantalink.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.renmod.quantalink.Quantalink;
import net.renmod.quantalink.block.QLBlocks;

import java.util.List;

public class QLConfigFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OverworldHarmonicQuartzOreKey = registerKey("harmonic_quartz_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NetherHarmonicQuartzOreKey = registerKey("nether_harmonic_quartz_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> EndHarmonicQuartzOreKey = registerKey("end_harmonic_quartz_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplacables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldHarmonicQuartzOres = List.of(OreConfiguration.target(stoneReplaceable,
                        QLBlocks.HarmonicQuartzOre.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, QLBlocks.DeepslateHarmonicQuartzOre.get().defaultBlockState()));

        register(context, OverworldHarmonicQuartzOreKey, Feature.ORE, new OreConfiguration(overworldHarmonicQuartzOres, 9));
        register(context, NetherHarmonicQuartzOreKey, Feature.ORE, new OreConfiguration(netherrackReplacables,
                QLBlocks.NetherHarmonicQuartzOre.get().defaultBlockState(), 9));
        register(context, EndHarmonicQuartzOreKey, Feature.ORE, new OreConfiguration(endReplaceables,
                QLBlocks.EndHarmonicQuartzOre.get().defaultBlockState(), 9));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Quantalink.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
