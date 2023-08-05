package de.johni0702.minecraft.bobby.sodium;

import de.johni0702.minecraft.bobby.mixin.sodium.SodiumWorldRendererAccessor;
import me.jellysquid.mods.sodium.client.render.SodiumWorldRenderer;
import me.jellysquid.mods.sodium.client.render.chunk.RenderSectionManager;

public class SodiumChunkStatusListenerImpl implements ChunkStatusListener {
    @Override
    public void onChunkAdded(int x, int z) {
        SodiumWorldRenderer sodiumRenderer = SodiumWorldRenderer.instanceNullable();
        if (sodiumRenderer != null) {
            RenderSectionManager renderSectionManager = ((SodiumWorldRendererAccessor) sodiumRenderer).getRenderSectionManager();
            renderSectionManager.onChunkAdded(x, z);
            //sodiumRenderer.onChunkLightAdded(x, z); // fake chunks have their light ready immediately
        }
    }

    @Override
    public void onChunkRemoved(int x, int z) {
        SodiumWorldRenderer sodiumRenderer = SodiumWorldRenderer.instanceNullable();
        if (sodiumRenderer != null) {
            RenderSectionManager renderSectionManager = ((SodiumWorldRendererAccessor) sodiumRenderer).getRenderSectionManager();
            renderSectionManager.onChunkRemoved(x, z);
        }
    }
}
