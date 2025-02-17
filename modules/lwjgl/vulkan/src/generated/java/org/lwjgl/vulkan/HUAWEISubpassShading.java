/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 * MACHINE GENERATED FILE, DO NOT EDIT
 */
package org.lwjgl.vulkan;

import org.lwjgl.system.*;

import static org.lwjgl.system.Checks.*;
import static org.lwjgl.system.JNI.*;

/**
 * This extension allows applications to execute a subpass shading pipeline in a subpass of a render pass in order to save memory bandwidth for algorithms like tile-based deferred rendering and forward plus. A subpass shading pipeline is a pipeline with the compute pipeline ability, allowed to read values from input attachments, and only allowed to be dispatched inside a stand-alone subpass. Its work dimension is defined by the render pass’s render area size. Its workgroup size (width, height) shall be a power-of-two number in width or height, with minimum value from 8, and maximum value shall be decided from the render pass attachments and sample counts but depends on implementation.
 * 
 * <p>The {@code GlobalInvocationId.xy} of a subpass shading pipeline is equal to the {@code FragCoord.xy} of a graphic pipeline in the same render pass subtracted the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.2-extensions/html/vkspec.html#VkRect2D">{@code offset}</a> of the {@link VkRenderPassBeginInfo}{@code ::renderArea}. {@code GlobalInvocationId.z} is mapped to the Layer if {@link EXTShaderViewportIndexLayer VK_EXT_shader_viewport_index_layer} is supported. The {@code GlobalInvocationId.xy} is equal to the index of the local workgroup multiplied by the size of the local workgroup plus the {@code LocalInvocationId} and the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.2-extensions/html/vkspec.html#VkRect2D">{@code offset}</a> of the {@link VkRenderPassBeginInfo}{@code ::renderArea}.</p>
 * 
 * <p>This extension allows a subpass’s pipeline bind point to be {@link #VK_PIPELINE_BIND_POINT_SUBPASS_SHADING_HUAWEI PIPELINE_BIND_POINT_SUBPASS_SHADING_HUAWEI}.</p>
 * 
 * <h5>Sample Code</h5>
 * 
 * <p>Example of subpass shading in a GLSL shader</p>
 * 
 * <pre><code>
 * #extension GL_HUAWEI_subpass_shading: enable
 * #extension GL_KHR_shader_subgroup_arithmetic: enable
 * 
 * layout(constant_id = 0) const uint tileWidth = 16;
 * layout(constant_id = 1) const uint tileHeight = 16;
 * layout(local_size_x_id = 0, local_size_y_id = 1, local_size_z = 1) in;
 * layout (set=0, binding=0, input_attachment_index=0) uniform subpassInput depth;
 * 
 * void main()
 * {
 *   float d = subpassLoad(depth);
 *   float minD = subgroupMin(d);
 *   float maxD = subgroupMax(d);
 * }</code></pre>
 * 
 * <p>Example of subpass shading dispatching in a subpass</p>
 * 
 * <pre><code>
 * vkCmdNextSubpass(commandBuffer, VK_SUBPASS_CONTENTS_INLINE);
 * vkCmdBindPipeline(commandBuffer, VK_PIPELINE_BIND_POINT_SUBPASS_SHADING_HUAWEI, subpassShadingPipeline);
 * vkCmdBindDescriptorSets(commandBuffer, VK_PIPELINE_BIND_POINT_SUBPASS_SHADING_HUAWEI, subpassShadingPipelineLayout,
 *   firstSet, descriptorSetCount, pDescriptorSets, dynamicOffsetCount, pDynamicOffsets);
 * vkCmdSubpassShadingHUAWEI(commandBuffer)
 * vkCmdEndRenderPass(commandBuffer);</code></pre>
 * 
 * <p>Example of subpass shading render pass creation</p>
 * 
 * <pre><code>
 * VkAttachmentDescription2 attachments[] = {
 *   {
 *     VK_STRUCTURE_TYPE_ATTACHMENT_DESCRIPTION_2, NULL,
 *     0, VK_FORMAT_R8G8B8A8_UNORM, VK_SAMPLE_COUNT_1_BIT,
 *     VK_ATTACHMENT_LOAD_OP_CLEAR, VK_ATTACHMENT_STORE_OP_DONT_CARE,
 *     VK_ATTACHMENT_LOAD_OP_DONT_CARE, VK_ATTACHMENT_LOAD_OP_DONT_CARE,
 *     VK_IMAGE_LAYOUT_COLOR_ATTACHMENT_OPTIMAL, VK_IMAGE_LAYOUT_COLOR_ATTACHMENT_OPTIMAL
 *   },
 *   {
 *     VK_STRUCTURE_TYPE_ATTACHMENT_DESCRIPTION_2, NULL,
 *     0, VK_FORMAT_R8G8B8A8_UNORM, VK_SAMPLE_COUNT_1_BIT,
 *     VK_ATTACHMENT_LOAD_OP_CLEAR, VK_ATTACHMENT_STORE_OP_DONT_CARE,
 *     VK_ATTACHMENT_LOAD_OP_DONT_CARE, VK_ATTACHMENT_LOAD_OP_DONT_CARE,
 *     VK_IMAGE_LAYOUT_COLOR_ATTACHMENT_OPTIMAL, VK_IMAGE_LAYOUT_COLOR_ATTACHMENT_OPTIMAL
 *   },
 *   {
 *     VK_STRUCTURE_TYPE_ATTACHMENT_DESCRIPTION_2, NULL,
 *     0, VK_FORMAT_R8G8B8A8_UNORM, VK_SAMPLE_COUNT_1_BIT,
 *     VK_ATTACHMENT_LOAD_OP_CLEAR, VK_ATTACHMENT_STORE_OP_DONT_CARE,
 *     VK_ATTACHMENT_LOAD_OP_DONT_CARE, VK_ATTACHMENT_LOAD_OP_DONT_CARE,
 *     VK_IMAGE_LAYOUT_COLOR_ATTACHMENT_OPTIMAL, VK_IMAGE_LAYOUT_COLOR_ATTACHMENT_OPTIMAL
 *   },
 *   {
 *     VK_STRUCTURE_TYPE_ATTACHMENT_DESCRIPTION_2, NULL,
 *     0, VK_FORMAT_D24_UNORM_S8_UINT, VK_SAMPLE_COUNT_1_BIT,
 *     VK_ATTACHMENT_LOAD_OP_CLEAR, VK_ATTACHMENT_STORE_OP_DONT_CARE,
 *     VK_ATTACHMENT_LOAD_OP_CLEAR, VK_ATTACHMENT_LOAD_OP_DONT_CARE,
 *     VK_IMAGE_LAYOUT_DEPTH_STENCIL_ATTACHMENT_OPTIMAL, VK_IMAGE_LAYOUT_DEPTH_STENCIL_ATTACHMENT_OPTIMAL
 *   },
 *   {
 *     VK_STRUCTURE_TYPE_ATTACHMENT_DESCRIPTION_2, NULL,
 *     0, VK_FORMAT_R8G8B8A8_UNORM, VK_SAMPLE_COUNT_1_BIT,
 *     VK_ATTACHMENT_LOAD_OP_CLEAR, VK_ATTACHMENT_STORE_OP_STORE,
 *     VK_ATTACHMENT_LOAD_OP_DONT_CARE, VK_ATTACHMENT_LOAD_OP_DONT_CARE,
 *     VK_IMAGE_LAYOUT_COLOR_ATTACHMENT_OPTIMAL, VK_IMAGE_LAYOUT_COLOR_ATTACHMENT_OPTIMAL
 *   }
 * };
 * 
 * VkAttachmentReference2 gBufferAttachmentReferences[] = {
 *   { VK_STRUCTURE_TYPE_ATTACHMENT_REFERENCE_2, NULL, 0, VK_IMAGE_LAYOUT_COLOR_ATTACHMENT_OPTIMAL, VK_IMAGE_ASPECT_COLOR_BIT },
 *   { VK_STRUCTURE_TYPE_ATTACHMENT_REFERENCE_2, NULL, 1, VK_IMAGE_LAYOUT_COLOR_ATTACHMENT_OPTIMAL, VK_IMAGE_ASPECT_COLOR_BIT },
 *   { VK_STRUCTURE_TYPE_ATTACHMENT_REFERENCE_2, NULL, 2, VK_IMAGE_LAYOUT_COLOR_ATTACHMENT_OPTIMAL, VK_IMAGE_ASPECT_COLOR_BIT }
 * };
 * VkAttachmentReference2 gBufferDepthStencilAttachmentReferences =
 *   { VK_STRUCTURE_TYPE_ATTACHMENT_REFERENCE_2, NULL, 3, VK_IMAGE_LAYOUT_DEPTH_STENCIL_ATTACHMENT_OPTIMAL, VK_IMAGE_ASPECT_DEPTH_BIT|VK_IMAGE_ASPECT_STENCIL_BIT };
 * VkAttachmentReference2 depthInputAttachmentReferences[] = {
 *   { VK_STRUCTURE_TYPE_ATTACHMENT_REFERENCE_2, NULL, 3, VK_IMAGE_LAYOUT_DEPTH_STENCIL_READ_ONLY_OPTIMAL, VK_IMAGE_ASPECT_DEPTH_BIT|VK_IMAGE_ASPECT_STENCIL_BIT };
 * };
 * VkAttachmentReference2 preserveAttachmentReferences[] = {
 *   { VK_STRUCTURE_TYPE_ATTACHMENT_REFERENCE_2, NULL, 0, VK_IMAGE_LAYOUT_COLOR_ATTACHMENT_OPTIMAL, VK_IMAGE_ASPECT_COLOR_BIT },
 *   { VK_STRUCTURE_TYPE_ATTACHMENT_REFERENCE_2, NULL, 1, VK_IMAGE_LAYOUT_COLOR_ATTACHMENT_OPTIMAL, VK_IMAGE_ASPECT_COLOR_BIT },
 *   { VK_STRUCTURE_TYPE_ATTACHMENT_REFERENCE_2, NULL, 2, VK_IMAGE_LAYOUT_COLOR_ATTACHMENT_OPTIMAL, VK_IMAGE_ASPECT_COLOR_BIT },
 *   { VK_STRUCTURE_TYPE_ATTACHMENT_REFERENCE_2, NULL, 3, VK_IMAGE_LAYOUT_DEPTH_STENCIL_ATTACHMENT_OPTIMAL, VK_IMAGE_ASPECT_DEPTH_BIT|VK_IMAGE_ASPECT_STENCIL_BIT }
 * }; // G buffer including depth/stencil
 * VkAttachmentReference2 colorAttachmentReferences[] = {
 *   { VK_STRUCTURE_TYPE_ATTACHMENT_REFERENCE_2, NULL, 4, VK_IMAGE_LAYOUT_COLOR_ATTACHMENT_OPTIMAL, VK_IMAGE_ASPECT_COLOR_BIT }
 * };
 * VkAttachmentReference2 resolveAttachmentReference =
 *   { VK_STRUCTURE_TYPE_ATTACHMENT_REFERENCE_2, NULL, 4, VK_IMAGE_LAYOUT_COLOR_ATTACHMENT_OPTIMAL, VK_IMAGE_ASPECT_COLOR_BIT };
 * 
 * VkSubpassDescription2 subpasses[] = {
 *   {
 *     VK_STRUCTURE_TYPE_SUBPASS_DESCRIPTION_2, NULL, 0, VK_PIPELINE_BIND_POINT_GRAPHICS, 0,
 *     0, NULL, // input
 *     sizeof(gBufferAttachmentReferences)/sizeof(gBufferAttachmentReferences[0]), gBufferAttachmentReferences, // color
 *     NULL, &amp;gBufferDepthStencilAttachmentReferences, // resolve &amp; DS
 *     0, NULL
 *   },
 *   {
 *     VK_STRUCTURE_TYPE_SUBPASS_DESCRIPTION_2, NULL, 0, VK_PIPELINE_BIND_POINT_SUBPASS_SHADING_HUAWEI , 0,
 *     sizeof(depthInputAttachmentReferences)/sizeof(depthInputAttachmentReferences[0]), depthInputAttachmentReferences, // input
 *     0, NULL, // color
 *     NULL, NULL, // resolve &amp; DS
 *     sizeof(preserveAttachmentReferences)/sizeof(preserveAttachmentReferences[0]), preserveAttachmentReferences,
 *   },
 *   {
 *     VK_STRUCTURE_TYPE_SUBPASS_DESCRIPTION_2, NULL, 0, VK_PIPELINE_BIND_POINT_GRAPHICS, 0,
 *     sizeof(gBufferAttachmentReferences)/sizeof(gBufferAttachmentReferences[0]), gBufferAttachmentReferences, // input
 *     sizeof(colorAttachmentReferences)/sizeof(colorAttachmentReferences[0]), colorAttachmentReferences, // color
 *     &amp;resolveAttachmentReference, &amp;gBufferDepthStencilAttachmentReferences, // resolve &amp; DS
 *     0, NULL
 *   },
 * };
 * 
 * VkMemoryBarrier2KHR fragmentToSubpassShading = {
 *   VK_STRUCTURE_TYPE_MEMORY_BARRIER_2_KHR, NULL,
 *   VK_PIPELINE_STAGE_2_FRAGMENT_SHADER_BIT_KHR, VK_ACCESS_COLOR_ATTACHMENT_WRITE_BIT|VK_ACCESS_DEPTH_STENCIL_ATTACHMENT_WRITE_BIT,
 *   VK_PIPELINE_STAGE_2_SUBPASS_SHADING_BIT_HUAWEI, VK_ACCESS_INPUT_ATTACHMENT_READ_BIT
 * };
 * 
 * VkMemoryBarrier2KHR subpassShadingToFragment = {
 *   VK_STRUCTURE_TYPE_MEMORY_BARRIER_2_KHR, NULL,
 *   VK_PIPELINE_STAGE_2_SUBPASS_SHADING_BIT_HUAWEI, VK_ACCESS_SHADER_WRITE_BIT,
 *   VK_PIPELINE_STAGE_2_FRAGMENT_SHADER_BIT_KHR, VK_ACCESS_SHADER_READ_BIT
 * };
 * 
 * VkSubpassDependency2 dependencies[] = {
 *   {
 *     VK_STRUCTURE_TYPE_SUBPASS_DEPENDENCY_2, &amp;fragmentToSubpassShading,
 *     0, 1,
 *     0, 0, 0, 0,
 *     0, 0
 *   },
 *   {
 *     VK_STRUCTURE_TYPE_SUBPASS_DEPENDENCY_2, &amp;subpassShadingToFragment,
 *     1, 2,
 *     0, 0, 0, 0,
 *     0, 0
 *   },
 * };
 * 
 * VkRenderPassCreateInfo2 renderPassCreateInfo = {
 *   VK_STRUCTURE_TYPE_RENDER_PASS_CREATE_INFO_2, NULL, 0,
 *     sizeof(attachments)/sizeof(attachments[0]), attachments,
 *     sizeof(subpasses)/sizeof(subpasses[0]), subpasses,
 *     sizeof(dependencies)/sizeof(dependencies[0]), dependencies,
 *     0, NULL
 * };
 * VKRenderPass renderPass;
 * vkCreateRenderPass2(device, &amp;renderPassCreateInfo, NULL, &amp;renderPass);</code></pre>
 * 
 * <p>Example of subpass shading pipeline creation</p>
 * 
 * <pre><code>
 * VkExtent2D maxWorkgroupSize;
 * 
 * VkSpecializationMapEntry subpassShadingConstantMapEntries[] = {
 *   { 0, 0 * sizeof(uint32_t), sizeof(uint32_t) },
 *   { 1, 1 * sizeof(uint32_t), sizeof(uint32_t) }
 * };
 * 
 * VkSpecializationInfo subpassShadingConstants = {
 *   2, subpassShadingConstantMapEntries,
 *   sizeof(VkExtent2D), &amp;maxWorkgroupSize
 * };
 * 
 * VkSubpassShadingPipelineCreateInfoHUAWEI subpassShadingPipelineCreateInfo {
 *   VK_STRUCTURE_TYPE_SUBPASSS_SHADING_PIPELINE_CREATE_INFO_HUAWEI, NULL,
 *   renderPass, 1
 * };
 * 
 * VkPipelineShaderStageCreateInfo subpassShadingPipelineStageCreateInfo {
 *   VK_STRUCTURE_TYPE_PIPELINE_SHADER_STAGE_CREATE_INFO, NULL,
 *   0, VK_SHADER_STAGE_SUBPASS_SHADING_BIT_HUAWEI,
 *   shaderModule, "subpass shading example",
 *   &amp;subpassShadingConstants
 * };
 * 
 * VkComputePipelineCreateInfo subpassShadingComputePipelineCreateInfo = {
 *   VK_STRUCTURE_TYPE_COMPUTE_PIPELINE_CREATE_INFO, NULL,
 *   0, &amp;subpassShadingPipelineCreateInfo,
 *   pipelineLayout, basePipelineHandle, basePipelineIndex
 * };
 * 
 * VKPipeline pipeline;
 * 
 * vkGetDeviceSubpassShadingMaxWorkgroupSizeHUAWEI(device, renderPass, &amp;maxWorkgroupSize);
 * vkCreateComputePipelines(device, pipelineCache, 1, &amp;subpassShadingComputePipelineCreateInfo, NULL, &amp;pipeline);</code></pre>
 * 
 * <h5>VK_HUAWEI_subpass_shading</h5>
 * 
 * <dl>
 * <dt><b>Name String</b></dt>
 * <dd>{@code VK_HUAWEI_subpass_shading}</dd>
 * <dt><b>Extension Type</b></dt>
 * <dd>Device extension</dd>
 * <dt><b>Registered Extension Number</b></dt>
 * <dd>370</dd>
 * <dt><b>Revision</b></dt>
 * <dd>2</dd>
 * <dt><b>Extension and Version Dependencies</b></dt>
 * <dd><ul>
 * <li>Requires Vulkan 1.0</li>
 * <li>Requires {@link KHRCreateRenderpass2 VK_KHR_create_renderpass2}</li>
 * <li>Requires {@link KHRSynchronization2 VK_KHR_synchronization2}</li>
 * </ul></dd>
 * <dt><b>Contact</b></dt>
 * <dd><ul>
 * <li>Hueilong Wang <a target="_blank" href="https://github.com/KhronosGroup/Vulkan-Docs/issues/new?title=VK_HUAWEI_subpass_shading:%20&amp;body=@wyvernathuawei%20">wyvernathuawei</a></li>
 * </ul></dd>
 * </dl>
 * 
 * <h5>Other Extension Metadata</h5>
 * 
 * <dl>
 * <dt><b>Last Modified Date</b></dt>
 * <dd>2021-06-01</dd>
 * <dt><b>Interactions and External Dependencies</b></dt>
 * <dd><ul>
 * <li>This extension requires <a target="_blank" href="https://github.com/KhronosGroup/GLSL/blob/master/extensions/huawei/GLSL_HUAWEI_subpass_shading.txt">{@code GL_HUAWEI_subpass_shading}</a>.</li>
 * <li>This extension requires <a target="_blank" href="https://htmlpreview.github.io/?https://github.com/KhronosGroup/SPIRV-Registry/blob/master/extensions/HUAWEI/SPV_HUAWEI_subpass_shading.html">{@code SPV_HUAWEI_subpass_shading}</a>.</li>
 * </ul></dd>
 * <dt><b>Contributors</b></dt>
 * <dd><ul>
 * <li>Hueilong Wang</li>
 * </ul></dd>
 * </dl>
 */
public class HUAWEISubpassShading {

    /** The extension specification version. */
    public static final int VK_HUAWEI_SUBPASS_SHADING_SPEC_VERSION = 2;

    /** The extension name. */
    public static final String VK_HUAWEI_SUBPASS_SHADING_EXTENSION_NAME = "VK_HUAWEI_subpass_shading";

    /**
     * Extends {@code VkStructureType}.
     * 
     * <h5>Enum values:</h5>
     * 
     * <ul>
     * <li>{@link #VK_STRUCTURE_TYPE_SUBPASS_SHADING_PIPELINE_CREATE_INFO_HUAWEI STRUCTURE_TYPE_SUBPASS_SHADING_PIPELINE_CREATE_INFO_HUAWEI}</li>
     * <li>{@link #VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SUBPASS_SHADING_FEATURES_HUAWEI STRUCTURE_TYPE_PHYSICAL_DEVICE_SUBPASS_SHADING_FEATURES_HUAWEI}</li>
     * <li>{@link #VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SUBPASS_SHADING_PROPERTIES_HUAWEI STRUCTURE_TYPE_PHYSICAL_DEVICE_SUBPASS_SHADING_PROPERTIES_HUAWEI}</li>
     * </ul>
     */
    public static final int
        VK_STRUCTURE_TYPE_SUBPASS_SHADING_PIPELINE_CREATE_INFO_HUAWEI       = 1000369000,
        VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SUBPASS_SHADING_FEATURES_HUAWEI   = 1000369001,
        VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SUBPASS_SHADING_PROPERTIES_HUAWEI = 1000369002;

    /** Extends {@code VkPipelineBindPoint}. */
    public static final int VK_PIPELINE_BIND_POINT_SUBPASS_SHADING_HUAWEI = 1000369003;

    /** Extends {@code VkPipelineStageFlagBits2KHR}. */
    public static final int VK_PIPELINE_STAGE_2_SUBPASS_SHADING_BIT_HUAWEI = 0x80;

    /** Extends {@code VkShaderStageFlagBits}. */
    public static final int VK_SHADER_STAGE_SUBPASS_SHADING_BIT_HUAWEI = 0x4000;

    protected HUAWEISubpassShading() {
        throw new UnsupportedOperationException();
    }

    // --- [ vkGetDeviceSubpassShadingMaxWorkgroupSizeHUAWEI ] ---

    /** Unsafe version of: {@link #vkGetDeviceSubpassShadingMaxWorkgroupSizeHUAWEI GetDeviceSubpassShadingMaxWorkgroupSizeHUAWEI} */
    public static int nvkGetDeviceSubpassShadingMaxWorkgroupSizeHUAWEI(VkDevice device, long renderpass, long pMaxWorkgroupSize) {
        long __functionAddress = device.getCapabilities().vkGetDeviceSubpassShadingMaxWorkgroupSizeHUAWEI;
        if (CHECKS) {
            check(__functionAddress);
        }
        return callPJPI(device.address(), renderpass, pMaxWorkgroupSize, __functionAddress);
    }

    /**
     * Query maximum supported subpass shading workgroup size for a give render pass.
     * 
     * <h5>C Specification</h5>
     * 
     * <p>A subpass shading pipeline’s workgroup size is a 2D vector with number of power-of-two in width and height. The maximum number of width and height is implementation dependent, and <b>may</b> vary for different formats and sample counts of attachments in a render pass.</p>
     * 
     * <p>To query the maximum workgroup size, call:</p>
     * 
     * <pre><code>
     * VkResult vkGetDeviceSubpassShadingMaxWorkgroupSizeHUAWEI(
     *     VkDevice                                    device,
     *     VkRenderPass                                renderpass,
     *     VkExtent2D*                                 pMaxWorkgroupSize);</code></pre>
     * 
     * <h5>Valid Usage (Implicit)</h5>
     * 
     * <ul>
     * <li>{@code device} <b>must</b> be a valid {@code VkDevice} handle</li>
     * <li>{@code renderpass} <b>must</b> be a valid {@code VkRenderPass} handle</li>
     * <li>{@code pMaxWorkgroupSize} <b>must</b> be a valid pointer to a {@link VkExtent2D} structure</li>
     * <li>{@code renderpass} <b>must</b> have been created, allocated, or retrieved from {@code device}</li>
     * </ul>
     * 
     * <h5>Return Codes</h5>
     * 
     * <dl>
     * <dt>On success, this command returns</dt>
     * <dd><ul>
     * <li>{@link VK10#VK_SUCCESS SUCCESS}</li>
     * <li>{@link VK10#VK_INCOMPLETE INCOMPLETE}</li>
     * </ul></dd>
     * <dt>On failure, this command returns</dt>
     * <dd><ul>
     * <li>{@link VK10#VK_ERROR_OUT_OF_HOST_MEMORY ERROR_OUT_OF_HOST_MEMORY}</li>
     * <li>{@link VK10#VK_ERROR_OUT_OF_DEVICE_MEMORY ERROR_OUT_OF_DEVICE_MEMORY}</li>
     * <li>{@link KHRSurface#VK_ERROR_SURFACE_LOST_KHR ERROR_SURFACE_LOST_KHR}</li>
     * </ul></dd>
     * </dl>
     * 
     * <h5>See Also</h5>
     * 
     * <p>{@link VkExtent2D}</p>
     *
     * @param device            a handle to a local device object that was used to create the given render pass.
     * @param pMaxWorkgroupSize a pointer to a {@link VkExtent2D} structure.
     */
    @NativeType("VkResult")
    public static int vkGetDeviceSubpassShadingMaxWorkgroupSizeHUAWEI(VkDevice device, @NativeType("VkRenderPass") long renderpass, @NativeType("VkExtent2D *") VkExtent2D pMaxWorkgroupSize) {
        return nvkGetDeviceSubpassShadingMaxWorkgroupSizeHUAWEI(device, renderpass, pMaxWorkgroupSize.address());
    }

    // --- [ vkCmdSubpassShadingHUAWEI ] ---

    /**
     * Dispatch compute work items.
     * 
     * <h5>C Specification</h5>
     * 
     * <p>A subpass shading dispatches a compute pipeline work with the work dimension of render area of the calling subpass and work groups are partitioned by specified work group size. Subpass operations like subpassLoad and subpassLoadMS are allowed to be used.</p>
     * 
     * <p>To record a subpass shading, call:</p>
     * 
     * <pre><code>
     * void vkCmdSubpassShadingHUAWEI(
     *     VkCommandBuffer                             commandBuffer);</code></pre>
     * 
     * <h5>Description</h5>
     * 
     * <p>When the command is executed, a global workgroup consisting of ceil (render area size / local workgroup size) local workgroups is assembled.</p>
     * 
     * <h5>Valid Usage</h5>
     * 
     * <ul>
     * <li>If a {@code VkSampler} created with {@code magFilter} or {@code minFilter} equal to {@link VK10#VK_FILTER_LINEAR FILTER_LINEAR} and {@code compareEnable} equal to {@link VK10#VK_FALSE FALSE} is used to sample a {@code VkImageView} as a result of this command, then the image view’s <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.2-extensions/html/vkspec.html#resources-image-view-format-features">format features</a> <b>must</b> contain {@link VK10#VK_FORMAT_FEATURE_SAMPLED_IMAGE_FILTER_LINEAR_BIT FORMAT_FEATURE_SAMPLED_IMAGE_FILTER_LINEAR_BIT}</li>
     * <li>If a {@code VkSampler} created with {@code mipmapMode} equal to {@link VK10#VK_SAMPLER_MIPMAP_MODE_LINEAR SAMPLER_MIPMAP_MODE_LINEAR} and {@code compareEnable} equal to {@link VK10#VK_FALSE FALSE} is used to sample a {@code VkImageView} as a result of this command, then the image view’s <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.2-extensions/html/vkspec.html#resources-image-view-format-features">format features</a> <b>must</b> contain {@link VK10#VK_FORMAT_FEATURE_SAMPLED_IMAGE_FILTER_LINEAR_BIT FORMAT_FEATURE_SAMPLED_IMAGE_FILTER_LINEAR_BIT}</li>
     * <li>If a {@code VkImageView} is accessed using atomic operations as a result of this command, then the image view’s <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.2-extensions/html/vkspec.html#resources-image-view-format-features">format features</a> <b>must</b> contain {@link VK10#VK_FORMAT_FEATURE_STORAGE_IMAGE_ATOMIC_BIT FORMAT_FEATURE_STORAGE_IMAGE_ATOMIC_BIT}</li>
     * <li>If a {@code VkImageView} is sampled with {@link EXTFilterCubic#VK_FILTER_CUBIC_EXT FILTER_CUBIC_EXT} as a result of this command, then the image view’s <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.2-extensions/html/vkspec.html#resources-image-view-format-features">format features</a> <b>must</b> contain {@link EXTFilterCubic#VK_FORMAT_FEATURE_SAMPLED_IMAGE_FILTER_CUBIC_BIT_EXT FORMAT_FEATURE_SAMPLED_IMAGE_FILTER_CUBIC_BIT_EXT}</li>
     * <li>Any {@code VkImageView} being sampled with {@link EXTFilterCubic#VK_FILTER_CUBIC_EXT FILTER_CUBIC_EXT} as a result of this command <b>must</b> have a {@code VkImageViewType} and format that supports cubic filtering, as specified by {@link VkFilterCubicImageViewImageFormatPropertiesEXT}{@code ::filterCubic} returned by {@code vkGetPhysicalDeviceImageFormatProperties2}</li>
     * <li>Any {@code VkImageView} being sampled with {@link EXTFilterCubic#VK_FILTER_CUBIC_EXT FILTER_CUBIC_EXT} with a reduction mode of either {@link VK12#VK_SAMPLER_REDUCTION_MODE_MIN SAMPLER_REDUCTION_MODE_MIN} or {@link VK12#VK_SAMPLER_REDUCTION_MODE_MAX SAMPLER_REDUCTION_MODE_MAX} as a result of this command <b>must</b> have a {@code VkImageViewType} and format that supports cubic filtering together with minmax filtering, as specified by {@link VkFilterCubicImageViewImageFormatPropertiesEXT}{@code ::filterCubicMinmax} returned by {@code vkGetPhysicalDeviceImageFormatProperties2}</li>
     * <li>Any {@code VkImage} created with a {@link VkImageCreateInfo}{@code ::flags} containing {@link NVCornerSampledImage#VK_IMAGE_CREATE_CORNER_SAMPLED_BIT_NV IMAGE_CREATE_CORNER_SAMPLED_BIT_NV} sampled as a result of this command <b>must</b> only be sampled using a {@code VkSamplerAddressMode} of {@link VK10#VK_SAMPLER_ADDRESS_MODE_CLAMP_TO_EDGE SAMPLER_ADDRESS_MODE_CLAMP_TO_EDGE}</li>
     * <li>For each set <em>n</em> that is statically used by the {@code VkPipeline} bound to the pipeline bind point used by this command, a descriptor set <b>must</b> have been bound to <em>n</em> at the same pipeline bind point, with a {@code VkPipelineLayout} that is compatible for set <em>n</em>, with the {@code VkPipelineLayout} used to create the current {@code VkPipeline}, as described in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.2-extensions/html/vkspec.html#descriptorsets-compatibility">Pipeline Layout Compatibility</a></li>
     * <li>For each push constant that is statically used by the {@code VkPipeline} bound to the pipeline bind point used by this command, a push constant value <b>must</b> have been set for the same pipeline bind point, with a {@code VkPipelineLayout} that is compatible for push constants, with the {@code VkPipelineLayout} used to create the current {@code VkPipeline}, as described in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.2-extensions/html/vkspec.html#descriptorsets-compatibility">Pipeline Layout Compatibility</a></li>
     * <li>Descriptors in each bound descriptor set, specified via {@code vkCmdBindDescriptorSets}, <b>must</b> be valid if they are statically used by the {@code VkPipeline} bound to the pipeline bind point used by this command</li>
     * <li>A valid pipeline <b>must</b> be bound to the pipeline bind point used by this command</li>
     * <li>If the {@code VkPipeline} object bound to the pipeline bind point used by this command requires any dynamic state, that state <b>must</b> have been set or inherited (if the {@link NVInheritedViewportScissor VK_NV_inherited_viewport_scissor} extension is enabled) for {@code commandBuffer}, and done so after any previously bound pipeline with the corresponding state not specified as dynamic</li>
     * <li>There <b>must</b> not have been any calls to dynamic state setting commands for any state not specified as dynamic in the {@code VkPipeline} object bound to the pipeline bind point used by this command, since that pipeline was bound</li>
     * <li>If the {@code VkPipeline} object bound to the pipeline bind point used by this command accesses a {@code VkSampler} object that uses unnormalized coordinates, that sampler <b>must</b> not be used to sample from any {@code VkImage} with a {@code VkImageView} of the type {@link VK10#VK_IMAGE_VIEW_TYPE_3D IMAGE_VIEW_TYPE_3D}, {@link VK10#VK_IMAGE_VIEW_TYPE_CUBE IMAGE_VIEW_TYPE_CUBE}, {@link VK10#VK_IMAGE_VIEW_TYPE_1D_ARRAY IMAGE_VIEW_TYPE_1D_ARRAY}, {@link VK10#VK_IMAGE_VIEW_TYPE_2D_ARRAY IMAGE_VIEW_TYPE_2D_ARRAY} or {@link VK10#VK_IMAGE_VIEW_TYPE_CUBE_ARRAY IMAGE_VIEW_TYPE_CUBE_ARRAY}, in any shader stage</li>
     * <li>If the {@code VkPipeline} object bound to the pipeline bind point used by this command accesses a {@code VkSampler} object that uses unnormalized coordinates, that sampler <b>must</b> not be used with any of the SPIR-V {@code OpImageSample*} or {@code OpImageSparseSample*} instructions with {@code ImplicitLod}, {@code Dref} or {@code Proj} in their name, in any shader stage</li>
     * <li>If the {@code VkPipeline} object bound to the pipeline bind point used by this command accesses a {@code VkSampler} object that uses unnormalized coordinates, that sampler <b>must</b> not be used with any of the SPIR-V {@code OpImageSample*} or {@code OpImageSparseSample*} instructions that includes a LOD bias or any offset values, in any shader stage</li>
     * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.2-extensions/html/vkspec.html#features-robustBufferAccess">robust buffer access</a> feature is not enabled, and if the {@code VkPipeline} object bound to the pipeline bind point used by this command accesses a uniform buffer, it <b>must</b> not access values outside of the range of the buffer as specified in the descriptor set bound to the same pipeline bind point</li>
     * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.2-extensions/html/vkspec.html#features-robustBufferAccess">robust buffer access</a> feature is not enabled, and if the {@code VkPipeline} object bound to the pipeline bind point used by this command accesses a storage buffer, it <b>must</b> not access values outside of the range of the buffer as specified in the descriptor set bound to the same pipeline bind point</li>
     * <li>If {@code commandBuffer} is an unprotected command buffer, any resource accessed by the {@code VkPipeline} object bound to the pipeline bind point used by this command <b>must</b> not be a protected resource</li>
     * <li>If a {@code VkImageView} is accessed using {@code OpImageWrite} as a result of this command, then the {@code Type} of the {@code Texel} operand of that instruction <b>must</b> have at least as many components as the image view’s format</li>
     * <li>If a {@code VkBufferView} is accessed using {@code OpImageWrite} as a result of this command, then the {@code Type} of the {@code Texel} operand of that instruction <b>must</b> have at least as many components as the buffer view’s format</li>
     * <li>If a {@code VkImageView} with a {@code VkFormat} that has a 64-bit channel width is accessed as a result of this command, the {@code SampledType} of the {@code OpTypeImage} operand of that instruction <b>must</b> have a {@code Width} of 64</li>
     * <li>If a {@code VkImageView} with a {@code VkFormat} that has a channel width less than 64-bit is accessed as a result of this command, the {@code SampledType} of the {@code OpTypeImage} operand of that instruction <b>must</b> have a {@code Width} of 32</li>
     * <li>If a {@code VkBufferView} with a {@code VkFormat} that has a 64-bit channel width is accessed as a result of this command, the {@code SampledType} of the {@code OpTypeImage} operand of that instruction <b>must</b> have a {@code Width} of 64</li>
     * <li>If a {@code VkBufferView} with a {@code VkFormat} that has a channel width less than 64-bit is accessed as a result of this command, the {@code SampledType} of the {@code OpTypeImage} operand of that instruction <b>must</b> have a {@code Width} of 32</li>
     * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.2-extensions/html/vkspec.html#features-sparseImageInt64Atomics">{@code sparseImageInt64Atomics}</a> feature is not enabled, {@code VkImage} objects created with the {@link VK10#VK_IMAGE_CREATE_SPARSE_RESIDENCY_BIT IMAGE_CREATE_SPARSE_RESIDENCY_BIT} flag <b>must</b> not be accessed by atomic instructions through an {@code OpTypeImage} with a {@code SampledType} with a {@code Width} of 64 by this command</li>
     * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.2-extensions/html/vkspec.html#features-sparseImageInt64Atomics">{@code sparseImageInt64Atomics}</a> feature is not enabled, {@code VkBuffer} objects created with the {@link VK10#VK_BUFFER_CREATE_SPARSE_RESIDENCY_BIT BUFFER_CREATE_SPARSE_RESIDENCY_BIT} flag <b>must</b> not be accessed by atomic instructions through an {@code OpTypeImage} with a {@code SampledType} with a {@code Width} of 64 by this command</li>
     * <li>This command must be called in a subpass with bind point VK_PIPELINE_BIND_POINT_SUBPASS_SHADING_HUAWEI. No draw commands can be called in the same subpass. Only one vkCmdSubpassShadingHUAWEI command can be called in a subpass.</li>
     * </ul>
     * 
     * <h5>Valid Usage (Implicit)</h5>
     * 
     * <ul>
     * <li>{@code commandBuffer} <b>must</b> be a valid {@code VkCommandBuffer} handle</li>
     * <li>{@code commandBuffer} <b>must</b> be in the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.2-extensions/html/vkspec.html#commandbuffers-lifecycle">recording state</a></li>
     * <li>The {@code VkCommandPool} that {@code commandBuffer} was allocated from <b>must</b> support graphics operations</li>
     * <li>This command <b>must</b> only be called inside of a render pass instance</li>
     * </ul>
     * 
     * <h5>Host Synchronization</h5>
     * 
     * <ul>
     * <li>Host access to {@code commandBuffer} <b>must</b> be externally synchronized</li>
     * <li>Host access to the {@code VkCommandPool} that {@code commandBuffer} was allocated from <b>must</b> be externally synchronized</li>
     * </ul>
     * 
     * <h5>Command Properties</h5>
     * 
     * <table class="lwjgl">
     * <thead><tr><th><a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.2-extensions/html/vkspec.html#VkCommandBufferLevel">Command Buffer Levels</a></th><th><a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.2-extensions/html/vkspec.html#vkCmdBeginRenderPass">Render Pass Scope</a></th><th><a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.2-extensions/html/vkspec.html#VkQueueFlagBits">Supported Queue Types</a></th></tr></thead>
     * <tbody><tr><td>Primary Secondary</td><td>Inside</td><td>Graphics</td></tr></tbody>
     * </table>
     *
     * @param commandBuffer the command buffer into which the command will be recorded.
     */
    public static void vkCmdSubpassShadingHUAWEI(VkCommandBuffer commandBuffer) {
        long __functionAddress = commandBuffer.getCapabilities().vkCmdSubpassShadingHUAWEI;
        if (CHECKS) {
            check(__functionAddress);
        }
        callPV(commandBuffer.address(), __functionAddress);
    }

}