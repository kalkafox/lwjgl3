/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package bgfx.templates

import bgfx.*
import org.lwjgl.generator.*

val BGFX = "BGFX".nativeClass(Module.BGFX, prefix = "BGFX", prefixMethod = "bgfx_", binding = BGFX_BINDING) {
    documentation =
        "Native bindings to the C API of the ${url("https://github.com/bkaradzic/bgfx", "bgfx")} library."

    IntConstant(
        "API version",

        "API_VERSION".."115"
    )

    ShortConstant(
        "Invalid handle",

        "INVALID_HANDLE"..0xFFFF.s
    )

    val StateFlags = LongConstant(
        "State",

        "STATE_WRITE_R"..0x0000000000000001L,
        "STATE_WRITE_G"..0x0000000000000002L,
        "STATE_WRITE_B"..0x0000000000000004L,
        "STATE_WRITE_A"..0x0000000000000008L,
        "STATE_WRITE_Z"..0x0000004000000000L,
        "STATE_WRITE_RGB".."BGFX_STATE_WRITE_R | BGFX_STATE_WRITE_G | BGFX_STATE_WRITE_B",
        "STATE_WRITE_MASK".."BGFX_STATE_WRITE_RGB | BGFX_STATE_WRITE_A | BGFX_STATE_WRITE_Z",

        "STATE_DEPTH_TEST_LESS"..0x0000000000000010L,
        "STATE_DEPTH_TEST_LEQUAL"..0x0000000000000020L,
        "STATE_DEPTH_TEST_EQUAL"..0x0000000000000030L,
        "STATE_DEPTH_TEST_GEQUAL"..0x0000000000000040L,
        "STATE_DEPTH_TEST_GREATER"..0x0000000000000050L,
        "STATE_DEPTH_TEST_NOTEQUAL"..0x0000000000000060L,
        "STATE_DEPTH_TEST_NEVER"..0x0000000000000070L,
        "STATE_DEPTH_TEST_ALWAYS"..0x0000000000000080L,

        "STATE_BLEND_ZERO"..0x0000000000001000L,
        "STATE_BLEND_ONE"..0x0000000000002000L,
        "STATE_BLEND_SRC_COLOR"..0x0000000000003000L,
        "STATE_BLEND_INV_SRC_COLOR"..0x0000000000004000L,
        "STATE_BLEND_SRC_ALPHA"..0x0000000000005000L,
        "STATE_BLEND_INV_SRC_ALPHA"..0x0000000000006000L,
        "STATE_BLEND_DST_ALPHA"..0x0000000000007000L,
        "STATE_BLEND_INV_DST_ALPHA"..0x0000000000008000L,
        "STATE_BLEND_DST_COLOR"..0x0000000000009000L,
        "STATE_BLEND_INV_DST_COLOR"..0x000000000000a000L,
        "STATE_BLEND_SRC_ALPHA_SAT"..0x000000000000b000L,
        "STATE_BLEND_FACTOR"..0x000000000000c000L,
        "STATE_BLEND_INV_FACTOR"..0x000000000000d000L,

        "STATE_BLEND_EQUATION_ADD"..0x0000000000000000L,
        "STATE_BLEND_EQUATION_SUB"..0x0000000010000000L,
        "STATE_BLEND_EQUATION_REVSUB"..0x0000000020000000L,
        "STATE_BLEND_EQUATION_MIN"..0x0000000030000000L,
        "STATE_BLEND_EQUATION_MAX"..0x0000000040000000L,

        "STATE_CULL_CW"..0x0000001000000000L,
        "STATE_CULL_CCW"..0x0000002000000000L,

        "STATE_PT_TRISTRIP"..0x0001000000000000L,
        "STATE_PT_LINES"..0x0002000000000000L,
        "STATE_PT_LINESTRIP"..0x0003000000000000L,
        "STATE_PT_POINTS"..0x0004000000000000L,

        "STATE_MSAA"..0x0100000000000000L,
        "STATE_LINEAA"..0x0200000000000000L,
        "STATE_CONSERVATIVE_RASTER"..0x0400000000000000L,

        "STATE_NONE"..0x0000000000000000L,

        "STATE_FRONT_CCW"..0x0000008000000000L,

        "STATE_BLEND_INDEPENDENT"..0x0000000400000000L,
        "STATE_BLEND_ALPHA_TO_COVERAGE"..0x0000000800000000L,

        "STATE_DEFAULT".."""(0L
        | BGFX_STATE_WRITE_RGB
        | BGFX_STATE_WRITE_A
        | BGFX_STATE_WRITE_Z
        | BGFX_STATE_DEPTH_TEST_LESS
        | BGFX_STATE_CULL_CW
        | BGFX_STATE_MSAA)
        """
    ).javaDocLinks

    LongConstant(
        "State",

        "STATE_DEPTH_TEST_MASK"..0x00000000000000f0L,
        "STATE_BLEND_MASK"..0x000000000ffff000L,
        "STATE_BLEND_EQUATION_MASK"..0x00000003f0000000L,
        "STATE_CULL_MASK"..0x0000003000000000L,
        "STATE_ALPHA_REF_MASK"..0x0000ff0000000000L,
        "STATE_PT_MASK"..0x0007000000000000L,
        "STATE_POINT_SIZE_MASK"..0x00f0000000000000L,
        "STATE_RESERVED_MASK".."0xe000000000000000L",
        "STATE_MASK".."0xffffffffffffffffL"
    )

    IntConstant(
        "State",

        "STATE_DEPTH_TEST_SHIFT".."4",
        "STATE_BLEND_SHIFT".."12",
        "STATE_BLEND_EQUATION_SHIFT".."28",
        "STATE_CULL_SHIFT".."36",
        "STATE_ALPHA_REF_SHIFT".."40",
        "STATE_PT_SHIFT".."48",
        "STATE_POINT_SIZE_SHIFT".."52",
        "STATE_RESERVED_SHIFT".."61"
    )

    val StencilFlags = IntConstant(
        "Stencil",

        "STENCIL_TEST_LESS"..0x00010000,
        "STENCIL_TEST_LEQUAL"..0x00020000,
        "STENCIL_TEST_EQUAL"..0x00030000,
        "STENCIL_TEST_GEQUAL"..0x00040000,
        "STENCIL_TEST_GREATER"..0x00050000,
        "STENCIL_TEST_NOTEQUAL"..0x00060000,
        "STENCIL_TEST_NEVER"..0x00070000,
        "STENCIL_TEST_ALWAYS"..0x00080000,

        "STENCIL_OP_FAIL_S_ZERO"..0x00000000,
        "STENCIL_OP_FAIL_S_KEEP"..0x00100000,
        "STENCIL_OP_FAIL_S_REPLACE"..0x00200000,
        "STENCIL_OP_FAIL_S_INCR"..0x00300000,
        "STENCIL_OP_FAIL_S_INCRSAT"..0x00400000,
        "STENCIL_OP_FAIL_S_DECR"..0x00500000,
        "STENCIL_OP_FAIL_S_DECRSAT"..0x00600000,
        "STENCIL_OP_FAIL_S_INVERT"..0x00700000,

        "STENCIL_OP_FAIL_Z_ZERO"..0x00000000,
        "STENCIL_OP_FAIL_Z_KEEP"..0x01000000,
        "STENCIL_OP_FAIL_Z_REPLACE"..0x02000000,
        "STENCIL_OP_FAIL_Z_INCR"..0x03000000,
        "STENCIL_OP_FAIL_Z_INCRSAT"..0x04000000,
        "STENCIL_OP_FAIL_Z_DECR"..0x05000000,
        "STENCIL_OP_FAIL_Z_DECRSAT"..0x06000000,
        "STENCIL_OP_FAIL_Z_INVERT"..0x07000000,

        "STENCIL_OP_PASS_Z_ZERO"..0x00000000,
        "STENCIL_OP_PASS_Z_KEEP"..0x10000000,
        "STENCIL_OP_PASS_Z_REPLACE"..0x20000000,
        "STENCIL_OP_PASS_Z_INCR"..0x30000000,
        "STENCIL_OP_PASS_Z_INCRSAT"..0x40000000,
        "STENCIL_OP_PASS_Z_DECR"..0x50000000,
        "STENCIL_OP_PASS_Z_DECRSAT"..0x60000000,
        "STENCIL_OP_PASS_Z_INVERT"..0x70000000,

        "STENCIL_NONE"..0x00000000,
        "STENCIL_DEFAULT"..0x00000000
    ).javaDocLinks

    IntConstant(
        "Stencil",

        "STENCIL_FUNC_REF_SHIFT".."0",
        "STENCIL_FUNC_REF_MASK"..0x000000ff,
        "STENCIL_FUNC_RMASK_SHIFT".."8",
        "STENCIL_FUNC_RMASK_MASK"..0x0000ff00,

        "STENCIL_TEST_SHIFT".."16",
        "STENCIL_TEST_MASK"..0x000f0000,

        "STENCIL_OP_FAIL_S_SHIFT".."20",
        "STENCIL_OP_FAIL_S_MASK"..0x00f00000,

        "STENCIL_OP_FAIL_Z_SHIFT".."24",
        "STENCIL_OP_FAIL_Z_MASK"..0x0f000000,

        "STENCIL_OP_PASS_Z_SHIFT".."28",
        "STENCIL_OP_PASS_Z_MASK".."0xf0000000",

        "STENCIL_MASK".."0xffffffff"
    )

    val ClearFlags = IntConstant(
        "Clear",

        "CLEAR_NONE"..0x0000,
        "CLEAR_COLOR"..0x0001,
        "CLEAR_DEPTH"..0x0002,
        "CLEAR_STENCIL"..0x0004,
        "CLEAR_DISCARD_COLOR_0"..0x0008,
        "CLEAR_DISCARD_COLOR_1"..0x0010,
        "CLEAR_DISCARD_COLOR_2"..0x0020,
        "CLEAR_DISCARD_COLOR_3"..0x0040,
        "CLEAR_DISCARD_COLOR_4"..0x0080,
        "CLEAR_DISCARD_COLOR_5"..0x0100,
        "CLEAR_DISCARD_COLOR_6"..0x0200,
        "CLEAR_DISCARD_COLOR_7"..0x0400,
        "CLEAR_DISCARD_DEPTH"..0x0800,
        "CLEAR_DISCARD_STENCIL"..0x1000,

        "CLEAR_DISCARD_COLOR_MASK".."""(0
        | BGFX_CLEAR_DISCARD_COLOR_0
        | BGFX_CLEAR_DISCARD_COLOR_1
        | BGFX_CLEAR_DISCARD_COLOR_2
        | BGFX_CLEAR_DISCARD_COLOR_3
        | BGFX_CLEAR_DISCARD_COLOR_4
        | BGFX_CLEAR_DISCARD_COLOR_5
        | BGFX_CLEAR_DISCARD_COLOR_6
        | BGFX_CLEAR_DISCARD_COLOR_7)
        """,

        "CLEAR_DISCARD_MASK".."""(0
        | BGFX_CLEAR_DISCARD_COLOR_MASK
        | BGFX_CLEAR_DISCARD_DEPTH
        | BGFX_CLEAR_DISCARD_STENCIL)
        """
    ).javaDocLinks

    val DiscardFlags = ByteConstant(
        """
        Rendering state discard.

        When state is preserved in submit, rendering states can be discarded on a finer grain.
        """,

        "DISCARD_NONE"..0x00.b,
        "DISCARD_BINDINGS"..0x01.b,
        "DISCARD_INDEX_BUFFER"..0x02.b,
        "DISCARD_INSTANCE_DATA"..0x04.b,
        "DISCARD_STATE"..0x08.b,
        "DISCARD_TRANSFORM"..0x10.b,
        "DISCARD_VERTEX_STREAMS"..0x20.b,
        "DISCARD_ALL"..0xff.b
    ).javaDocLinks

    val DebugFlags = EnumConstant(
        "Debug",

        "DEBUG_NONE".enum("", 0x00000000),
        "DEBUG_WIREFRAME".enum("Wireframe rendering. All rendering primitives will be rendered as lines.", 0x00000001),
        "DEBUG_IFH".enum(
            """
            Enable infinitely fast hardware test. No draw calls will be submitted to driver. It's useful when profiling to quickly assess bottleneck between
            CPU and GPU.
            """,
            0x00000002
        ),
        "DEBUG_STATS".enum("Display internal statistics.", 0x00000004),
        "DEBUG_TEXT".enum("Display debug text.", 0x00000008),
        "DEBUG_PROFILER".enum("Enable profiler.", 0x00000010)
    ).javaDocLinks

    val BufferFlags = IntConstant(
        "Buffer creation flags",

        "BUFFER_NONE"..0x0000,
        "BUFFER_COMPUTE_READ"..0x0100,
        "BUFFER_COMPUTE_WRITE"..0x0200,
        "BUFFER_DRAW_INDIRECT"..0x0400,
        "BUFFER_ALLOW_RESIZE"..0x0800,
        "BUFFER_INDEX32"..0x1000,

        "BUFFER_COMPUTE_READ_WRITE".."""(0
        | BGFX_BUFFER_COMPUTE_READ
        | BGFX_BUFFER_COMPUTE_WRITE)
        """
    ).javaDocLinks

    ShortConstant(
        "Buffer",

        "BUFFER_COMPUTE_FORMAT_8x1"..0x0001.s,
        "BUFFER_COMPUTE_FORMAT_8x2"..0x0002.s,
        "BUFFER_COMPUTE_FORMAT_8x4"..0x0003.s,
        "BUFFER_COMPUTE_FORMAT_16x1"..0x0004.s,
        "BUFFER_COMPUTE_FORMAT_16x2"..0x0005.s,
        "BUFFER_COMPUTE_FORMAT_16x4"..0x0006.s,
        "BUFFER_COMPUTE_FORMAT_32x1"..0x0007.s,
        "BUFFER_COMPUTE_FORMAT_32x2"..0x0008.s,
        "BUFFER_COMPUTE_FORMAT_32x4"..0x0009.s,
        "BUFFER_COMPUTE_FORMAT_SHIFT".."0",
        "BUFFER_COMPUTE_FORMAT_MASK"..0x000f.s,

        "BUFFER_COMPUTE_TYPE_INT"..0x0010.s,
        "BUFFER_COMPUTE_TYPE_UINT"..0x0020.s,
        "BUFFER_COMPUTE_TYPE_FLOAT"..0x0030.s,
        "BUFFER_COMPUTE_TYPE_SHIFT".."4",
        "BUFFER_COMPUTE_TYPE_MASK"..0x0030.s
    )

    val TextureFlags = LongConstant(
        "Texture creation flags.",

        "TEXTURE_NONE"..0x0000000000000000L,
        "TEXTURE_MSAA_SAMPLE"..0x0000000800000000L,
        "TEXTURE_RT"..0x0000001000000000L,
        "TEXTURE_RT_MSAA_X2"..0x0000002000000000L,
        "TEXTURE_RT_MSAA_X4"..0x0000003000000000L,
        "TEXTURE_RT_MSAA_X8"..0x0000004000000000L,
        "TEXTURE_RT_MSAA_X16"..0x0000005000000000L,
        "TEXTURE_RT_WRITE_ONLY"..0x0000008000000000L,
        "TEXTURE_COMPUTE_WRITE"..0x0000100000000000L,
        "TEXTURE_SRGB"..0x0000200000000000L,
        "TEXTURE_BLIT_DST"..0x0000400000000000L,
        "TEXTURE_READ_BACK"..0x0000800000000000L
    ).javaDocLinks

    IntConstant(
        "Texture shifts.",

        "TEXTURE_RT_MSAA_SHIFT".."36"
    )

    LongConstant(
        "Texture masks.",

        "TEXTURE_RT_MSAA_MASK"..0x0000007000000000L,
        "TEXTURE_RT_MASK"..0x000000f000000000L
    )

    val SamplerFlags = IntConstant(
        "Sample flags.",

        "SAMPLER_NONE"..0x00000000,

        "SAMPLER_U_MIRROR"..0x00000001,
        "SAMPLER_U_CLAMP"..0x00000002,
        "SAMPLER_U_BORDER"..0x00000003,

        "SAMPLER_V_MIRROR"..0x00000004,
        "SAMPLER_V_CLAMP"..0x00000008,
        "SAMPLER_V_BORDER"..0x0000000c,

        "SAMPLER_W_MIRROR"..0x00000010,
        "SAMPLER_W_CLAMP"..0x00000020,
        "SAMPLER_W_BORDER"..0x00000030,

        "SAMPLER_UVW_MIRROR".."(0 | BGFX_SAMPLER_U_MIRROR | BGFX_SAMPLER_V_MIRROR | BGFX_SAMPLER_W_MIRROR)",
        "SAMPLER_UVW_CLAMP".."(0 | BGFX_SAMPLER_U_CLAMP | BGFX_SAMPLER_V_CLAMP | BGFX_SAMPLER_W_CLAMP)",
        "SAMPLER_UVW_BORDER".."(0 | BGFX_SAMPLER_U_BORDER | BGFX_SAMPLER_V_BORDER | BGFX_SAMPLER_W_BORDER)",

        "SAMPLER_MIN_POINT"..0x00000040,
        "SAMPLER_MIN_ANISOTROPIC"..0x00000080,

        "SAMPLER_MAG_POINT"..0x00000100,
        "SAMPLER_MAG_ANISOTROPIC"..0x00000200,

        "SAMPLER_MIP_POINT"..0x00000400,

        "SAMPLER_POINT".."(0 | BGFX_SAMPLER_MIN_POINT | BGFX_SAMPLER_MAG_POINT | BGFX_SAMPLER_MIP_POINT)",

        "SAMPLER_COMPARE_LESS"..0x00010000,
        "SAMPLER_COMPARE_LEQUAL"..0x00020000,
        "SAMPLER_COMPARE_EQUAL"..0x00030000,
        "SAMPLER_COMPARE_GEQUAL"..0x00040000,
        "SAMPLER_COMPARE_GREATER"..0x00050000,
        "SAMPLER_COMPARE_NOTEQUAL"..0x00060000,
        "SAMPLER_COMPARE_NEVER"..0x00070000,
        "SAMPLER_COMPARE_ALWAYS"..0x00080000,

        "SAMPLER_SAMPLE_STENCIL"..0x00100000
    ).javaDocLinks

    IntConstant(
        "Sampler shifts/masks",

        "SAMPLER_U_SHIFT".."0",
        "SAMPLER_U_MASK"..0x00000003,

        "SAMPLER_V_SHIFT".."2",
        "SAMPLER_V_MASK"..0x0000000c,

        "SAMPLER_W_SHIFT".."4",
        "SAMPLER_W_MASK"..0x00000030,

        "SAMPLER_MIN_SHIFT".."6",
        "SAMPLER_MIN_MASK"..0x000000c0,

        "SAMPLER_MAG_SHIFT".."8",
        "SAMPLER_MAG_MASK"..0x00000300,

        "SAMPLER_MIP_SHIFT".."10",
        "SAMPLER_MIP_MASK"..0x00000400,

        "SAMPLER_COMPARE_SHIFT".."16",
        "SAMPLER_COMPARE_MASK"..0x000f0000,

        "SAMPLER_BORDER_COLOR_SHIFT".."24",
        "SAMPLER_BORDER_COLOR_MASK"..0x0f000000,

        "SAMPLER_RESERVED_SHIFT".."28",
        "SAMPLER_RESERVED_MASK".."0xF0000000",

        "SAMPLER_SAMPLER_BITS_MASK".."""(0
        | BGFX_SAMPLER_U_MASK
        | BGFX_SAMPLER_V_MASK
        | BGFX_SAMPLER_W_MASK
        | BGFX_SAMPLER_MIN_MASK
        | BGFX_SAMPLER_MAG_MASK
        | BGFX_SAMPLER_MIP_MASK
        | BGFX_SAMPLER_COMPARE_MASK)
        """
    )

    val ResetFlags = IntConstant(
        "Reset",

        "RESET_NONE"..0x00000000,
        "RESET_FULLSCREEN"..0x00000001,
        "RESET_FULLSCREEN_SHIFT".."0",
        "RESET_FULLSCREEN_MASK"..0x00000001,
        "RESET_MSAA_X2"..0x00000010,
        "RESET_MSAA_X4"..0x00000020,
        "RESET_MSAA_X8"..0x00000030,
        "RESET_MSAA_X16"..0x00000040,
        "RESET_MSAA_SHIFT".."4",
        "RESET_MSAA_MASK"..0x00000070,
        "RESET_VSYNC"..0x00000080,
        "RESET_MAXANISOTROPY"..0x00000100,
        "RESET_CAPTURE"..0x00000200,
        "RESET_FLUSH_AFTER_RENDER"..0x00002000,
        "RESET_FLIP_AFTER_RENDER"..0x00004000,
        "RESET_SRGB_BACKBUFFER"..0x00008000,
        "RESET_HDR10"..0x00010000,
        "RESET_HIDPI"..0x00020000,
        "RESET_DEPTH_CLAMP"..0x00040000,
        "RESET_SUSPEND"..0x00080000
    ).javaDocLinks

    IntConstant(
        "Reset",

        "RESET_RESERVED_SHIFT".."31",
        "RESET_RESERVED_MASK".."0x80000000"
    )

    LongConstant(
        "Caps",

        "CAPS_ALPHA_TO_COVERAGE"..0x0000000000000001L,
        "CAPS_BLEND_INDEPENDENT"..0x0000000000000002L,
        "CAPS_COMPUTE"..0x0000000000000004L,
        "CAPS_CONSERVATIVE_RASTER"..0x0000000000000008L,
        "CAPS_DRAW_INDIRECT"..0x0000000000000010L,
        "CAPS_FRAGMENT_DEPTH"..0x0000000000000020L,
        "CAPS_FRAGMENT_ORDERING"..0x0000000000000040L,
        "CAPS_GRAPHICS_DEBUGGER"..0x0000000000000080L,
        "CAPS_HDR10"..0x0000000000000100L,
        "CAPS_HIDPI"..0x0000000000000200L,
        "CAPS_IMAGE_RW"..0x0000000000000400L,
        "CAPS_INDEX32"..0x000000000000800L,
        "CAPS_INSTANCING"..0x0000000000001000L,
        "CAPS_OCCLUSION_QUERY"..0x0000000000002000L,
        "CAPS_RENDERER_MULTITHREADED"..0x0000000000004000L,
        "CAPS_SWAP_CHAIN"..0x000000000008000L,
        "CAPS_TEXTURE_2D_ARRAY"..0x0000000000010000L,
        "CAPS_TEXTURE_3D"..0x0000000000020000L,
        "CAPS_TEXTURE_BLIT"..0x0000000000040000L,
        "CAPS_TEXTURE_COMPARE_RESERVED"..0x0000000000080000L,
        "CAPS_TEXTURE_COMPARE_LEQUAL"..0x0000000000100000L,
        "CAPS_TEXTURE_COMPARE_ALL".."BGFX_CAPS_TEXTURE_COMPARE_RESERVED | BGFX_CAPS_TEXTURE_COMPARE_LEQUAL",
        "CAPS_TEXTURE_CUBE_ARRAY"..0x0000000000200000L,
        "CAPS_TEXTURE_DIRECT_ACCESS"..0x0000000000400000L,
        "CAPS_TEXTURE_READ_BACK"..0x0000000000800000L,
        "CAPS_VERTEX_ATTRIB_HALF"..0x0000000001000000L,
        "CAPS_VERTEX_ATTRIB_UINT10"..0x0000000002000000L,
        "CAPS_VERTEX_ID"..0x0000000004000000L,
        "CAPS_VIEWPORT_LAYER_ARRAY"..0x0000000008000000L
    )

    IntConstant(
        "Format caps",

        "CAPS_FORMAT_TEXTURE_NONE"..0x00000000,
        "CAPS_FORMAT_TEXTURE_2D"..0x00000001,
        "CAPS_FORMAT_TEXTURE_2D_SRGB"..0x00000002,
        "CAPS_FORMAT_TEXTURE_2D_EMULATED"..0x00000004,
        "CAPS_FORMAT_TEXTURE_3D"..0x00000008,
        "CAPS_FORMAT_TEXTURE_3D_SRGB"..0x00000010,
        "CAPS_FORMAT_TEXTURE_3D_EMULATED"..0x00000020,
        "CAPS_FORMAT_TEXTURE_CUBE"..0x00000040,
        "CAPS_FORMAT_TEXTURE_CUBE_SRGB"..0x00000080,
        "CAPS_FORMAT_TEXTURE_CUBE_EMULATED"..0x00000100,
        "CAPS_FORMAT_TEXTURE_VERTEX"..0x00000200,
        "CAPS_FORMAT_TEXTURE_IMAGE_READ"..0x00000400,
        "CAPS_FORMAT_TEXTURE_IMAGE_WRITE"..0x00000800,
        "CAPS_FORMAT_TEXTURE_FRAMEBUFFER"..0x00001000,
        "CAPS_FORMAT_TEXTURE_FRAMEBUFFER_MSAA"..0x00002000,
        "CAPS_FORMAT_TEXTURE_MSAA"..0x00004000,
        "CAPS_FORMAT_TEXTURE_MIP_AUTOGEN"..0x00008000
    )

    ByteConstant(
        "Resolve flags.",

        "RESOLVE_NONE"..0x00.b,
        "RESOLVE_AUTO_GEN_MIPS"..0x01.b
    )

    ShortConstant(
        "PCI",

        "PCI_ID_NONE"..0x0000.s,
        "PCI_ID_SOFTWARE_RASTERIZER"..0x0001.s,
        "PCI_ID_AMD"..0x1002.s,
        "PCI_ID_INTEL".."(short)0x8086",
        "PCI_ID_NVIDIA"..0x10de.s
    )

    val CubeMapSides = ByteConstant(
        "Cubemap",

        "CUBE_MAP_POSITIVE_X"..0x00.b,
        "CUBE_MAP_NEGATIVE_X"..0x01.b,
        "CUBE_MAP_POSITIVE_Y"..0x02.b,
        "CUBE_MAP_NEGATIVE_Y"..0x03.b,
        "CUBE_MAP_POSITIVE_Z"..0x04.b,
        "CUBE_MAP_NEGATIVE_Z"..0x05.b
    ).javaDocLinks

    EnumConstant(
        "Fatal errors ({@code bgfx_fatal_t}).",

        "FATAL_DEBUG_CHECK".enum,
        "FATAL_INVALID_SHADER".enum,
        "FATAL_UNABLE_TO_INITIALIZE".enum,
        "FATAL_UNABLE_TO_CREATE_TEXTURE".enum,
        "FATAL_DEVICE_LOST".enum,

        "FATAL_COUNT".enum
    )

    val RendererType = EnumConstant(
        "Renderer backend type. ({@code bgfx_renderer_type_t})",

        "RENDERER_TYPE_NOOP".enum("No rendering."),
        "RENDERER_TYPE_AGC".enum("AGC"),
        "RENDERER_TYPE_DIRECT3D9".enum("Direct3D 9.0"),
        "RENDERER_TYPE_DIRECT3D11".enum("Direct3D 11.0"),
        "RENDERER_TYPE_DIRECT3D12".enum("Direct3D 12.0"),
        "RENDERER_TYPE_GNM".enum("GNM"),
        "RENDERER_TYPE_METAL".enum("Metal"),
        "RENDERER_TYPE_NVN".enum("Nvn"),
        "RENDERER_TYPE_OPENGLES".enum("OpenGL ES 2.0+"),
        "RENDERER_TYPE_OPENGL".enum("OpenGL 2.1+"),
        "RENDERER_TYPE_VULKAN".enum("Vulkan"),
        "BGFX_RENDERER_TYPE_WEBGPU".enum("WebGPU"),

        "RENDERER_TYPE_COUNT".enum
    ).javaDocLinks

    val Access = EnumConstant(
        "Access mode ({@code bgfx_access_t})",

        "ACCESS_READ".enum("Read"),
        "ACCESS_WRITE".enum("Write"),
        "ACCESS_READWRITE".enum("Read and write"),

        "ACCESS_COUNT".enum
    ).javaDocLinksSkipCount

    val Attrib = EnumConstant(
        "Vertex attribute ({@code bgfx_attrib_t}).",

        "ATTRIB_POSITION".enum,
        "ATTRIB_NORMAL".enum,
        "ATTRIB_TANGENT".enum,
        "ATTRIB_BITANGENT".enum,
        "ATTRIB_COLOR0".enum,
        "ATTRIB_COLOR1".enum,
        "ATTRIB_COLOR2".enum,
        "ATTRIB_COLOR3".enum,
        "ATTRIB_INDICES".enum,
        "ATTRIB_WEIGHT".enum,
        "ATTRIB_TEXCOORD0".enum,
        "ATTRIB_TEXCOORD1".enum,
        "ATTRIB_TEXCOORD2".enum,
        "ATTRIB_TEXCOORD3".enum,
        "ATTRIB_TEXCOORD4".enum,
        "ATTRIB_TEXCOORD5".enum,
        "ATTRIB_TEXCOORD6".enum,
        "ATTRIB_TEXCOORD7".enum,

        "ATTRIB_COUNT".enum("", "BGFX_ATTRIB_TEXCOORD7 + 1")
    ).javaDocLinksSkipCount

    val AttribType = EnumConstant(
        "Vertex attribute type ({@code bgfx_attrib_type_t}).",

        "ATTRIB_TYPE_UINT8".enum("Uint8"),
        "ATTRIB_TYPE_UINT10".enum("Uint10, availability depends on: #CAPS_VERTEX_ATTRIB_UINT10."),
        "ATTRIB_TYPE_INT16".enum("Int16"),
        "ATTRIB_TYPE_HALF".enum("Half, availability depends on: #CAPS_VERTEX_ATTRIB_HALF`."),
        "ATTRIB_TYPE_FLOAT".enum("Float"),

        "ATTRIB_TYPE_COUNT".enum("", "BGFX_ATTRIB_TYPE_FLOAT + 1")
    ).javaDocLinks

    val TextureFormat = EnumConstant(
        """
        Texture format ({@code bgfx_texture_format_t}). Notation:
        ${codeBlock("""
RGBA16S
^   ^ ^
|   | +-- [ ]Unorm
|   |     [F]loat
|   |     [S]norm
|   |     [I]nt
|   |     [U]int
|   +---- Number of bits per component
+-------- Components""")}

        Availability depends on Caps.
        """,

        "TEXTURE_FORMAT_BC1".enum("DXT1 R5G6B5A1"),
        "TEXTURE_FORMAT_BC2".enum("DXT3 R5G6B5A4"),
        "TEXTURE_FORMAT_BC3".enum("DXT5 R5G6B5A8"),
        "TEXTURE_FORMAT_BC4".enum("LATC1/ATI1 R8"),
        "TEXTURE_FORMAT_BC5".enum("LATC2/ATI2 RG8"),
        "TEXTURE_FORMAT_BC6H".enum("BC6H RGB16F"),
        "TEXTURE_FORMAT_BC7".enum("BC7 RGB 4-7 bits per color channel, 0-8 bits alpha"),
        "TEXTURE_FORMAT_ETC1".enum("ETC1 RGB8"),
        "TEXTURE_FORMAT_ETC2".enum("ETC2 RGB8"),
        "TEXTURE_FORMAT_ETC2A".enum("ETC2 RGBA8"),
        "TEXTURE_FORMAT_ETC2A1".enum("ETC2 RGB8A1"),
        "TEXTURE_FORMAT_PTC12".enum("PVRTC1 RGB 2BPP"),
        "TEXTURE_FORMAT_PTC14".enum("PVRTC1 RGB 4BPP"),
        "TEXTURE_FORMAT_PTC12A".enum("PVRTC1 RGBA 2BPP"),
        "TEXTURE_FORMAT_PTC14A".enum("PVRTC1 RGBA 4BPP"),
        "TEXTURE_FORMAT_PTC22".enum("PVRTC2 RGBA 2BPP"),
        "TEXTURE_FORMAT_PTC24".enum("PVRTC2 RGBA 4BPP"),
        "TEXTURE_FORMAT_ATC".enum("ATC RGB 4BPP"),
        "TEXTURE_FORMAT_ATCE".enum("ATCE RGBA 8 BPP explicit alpha"),
        "TEXTURE_FORMAT_ATCI".enum("ATCI RGBA 8 BPP interpolated alpha"),
        "TEXTURE_FORMAT_ASTC4x4".enum("ASTC 4x4 8.0 BPP"),
        "TEXTURE_FORMAT_ASTC5x5".enum("ASTC 5x5 5.12 BPP"),
        "TEXTURE_FORMAT_ASTC6x6".enum("ASTC 6x6 3.56 BPP"),
        "TEXTURE_FORMAT_ASTC8x5".enum("ASTC 8x5 3.20 BPP"),
        "TEXTURE_FORMAT_ASTC8x6".enum("ASTC 8x6 2.67 BPP"),
        "TEXTURE_FORMAT_ASTC10x5".enum("ASTC 10x5 2.56 BPP"),

        "TEXTURE_FORMAT_UNKNOWN".enum,

        "TEXTURE_FORMAT_R1".enum,
        "TEXTURE_FORMAT_A8".enum,
        "TEXTURE_FORMAT_R8".enum,
        "TEXTURE_FORMAT_R8I".enum,
        "TEXTURE_FORMAT_R8U".enum,
        "TEXTURE_FORMAT_R8S".enum,
        "TEXTURE_FORMAT_R16".enum,
        "TEXTURE_FORMAT_R16I".enum,
        "TEXTURE_FORMAT_R16U".enum,
        "TEXTURE_FORMAT_R16F".enum,
        "TEXTURE_FORMAT_R16S".enum,
        "TEXTURE_FORMAT_R32I".enum,
        "TEXTURE_FORMAT_R32U".enum,
        "TEXTURE_FORMAT_R32F".enum,
        "TEXTURE_FORMAT_RG8".enum,
        "TEXTURE_FORMAT_RG8I".enum,
        "TEXTURE_FORMAT_RG8U".enum,
        "TEXTURE_FORMAT_RG8S".enum,
        "TEXTURE_FORMAT_RG16".enum,
        "TEXTURE_FORMAT_RG16I".enum,
        "TEXTURE_FORMAT_RG16U".enum,
        "TEXTURE_FORMAT_RG16F".enum,
        "TEXTURE_FORMAT_RG16S".enum,
        "TEXTURE_FORMAT_RG32I".enum,
        "TEXTURE_FORMAT_RG32U".enum,
        "TEXTURE_FORMAT_RG32F".enum,
        "TEXTURE_FORMAT_RGB8".enum,
        "TEXTURE_FORMAT_RGB8I".enum,
        "TEXTURE_FORMAT_RGB8U".enum,
        "TEXTURE_FORMAT_RGB8S".enum,
        "TEXTURE_FORMAT_RGB9E5F".enum,
        "TEXTURE_FORMAT_BGRA8".enum,
        "TEXTURE_FORMAT_RGBA8".enum,
        "TEXTURE_FORMAT_RGBA8I".enum,
        "TEXTURE_FORMAT_RGBA8U".enum,
        "TEXTURE_FORMAT_RGBA8S".enum,
        "TEXTURE_FORMAT_RGBA16".enum,
        "TEXTURE_FORMAT_RGBA16I".enum,
        "TEXTURE_FORMAT_RGBA16U".enum,
        "TEXTURE_FORMAT_RGBA16F".enum,
        "TEXTURE_FORMAT_RGBA16S".enum,
        "TEXTURE_FORMAT_RGBA32I".enum,
        "TEXTURE_FORMAT_RGBA32U".enum,
        "TEXTURE_FORMAT_RGBA32F".enum,
        "TEXTURE_FORMAT_R5G6B5".enum,
        "TEXTURE_FORMAT_RGBA4".enum,
        "TEXTURE_FORMAT_RGB5A1".enum,
        "TEXTURE_FORMAT_RGB10A2".enum,
        "TEXTURE_FORMAT_RG11B10F".enum,

        "TEXTURE_FORMAT_UNKNOWN_DEPTH".enum,

        "TEXTURE_FORMAT_D16".enum,
        "TEXTURE_FORMAT_D24".enum,
        "TEXTURE_FORMAT_D24S8".enum,
        "TEXTURE_FORMAT_D32".enum,
        "TEXTURE_FORMAT_D16F".enum,
        "TEXTURE_FORMAT_D24F".enum,
        "TEXTURE_FORMAT_D32F".enum,
        "TEXTURE_FORMAT_D0S8".enum,

        "TEXTURE_FORMAT_COUNT".enum("", "BGFX_TEXTURE_FORMAT_D0S8 + 1")
    ).javaDocLinksSkipCount

    val UniformType = EnumConstant(
        "Uniform type ({@code bgfx_uniform_type_t}).",

        "UNIFORM_TYPE_SAMPLER".enum("Sampler."),
        "UNIFORM_TYPE_END".enum("Reserved, do not use."),

        "UNIFORM_TYPE_VEC4".enum("4 floats vector."),
        "UNIFORM_TYPE_MAT3".enum("3x3 matrix."),
        "UNIFORM_TYPE_MAT4".enum("4x4 matrix."),

        "UNIFORM_TYPE_COUNT".enum
    ).javaDocLinksSkipCount

    val BackbufferRatio = EnumConstant(
        "Backbuffer ratio ({@code bgfx_backbuffer_ratio_t}).",

        "BACKBUFFER_RATIO_EQUAL".enum("Equal to backbuffer."),
        "BACKBUFFER_RATIO_HALF".enum("One half size of backbuffer."),
        "BACKBUFFER_RATIO_QUARTER".enum("One quarter size of backbuffer."),
        "BACKBUFFER_RATIO_EIGHTH".enum("One eighth size of backbuffer."),
        "BACKBUFFER_RATIO_SIXTEENTH".enum("One sixteenth size of backbuffer."),
        "BACKBUFFER_RATIO_DOUBLE".enum("Double size of backbuffer."),

        "BACKBUFFER_RATIO_COUNT".enum
    ).javaDocLinksSkipCount

    EnumConstant(
        "Occlusion query result ({@code bgfx_occlusion_query_result_t}).",

        "OCCLUSION_QUERY_RESULT_INVISIBLE".enum("Query failed test."),
        "OCCLUSION_QUERY_RESULT_VISIBLE".enum("Query passed test."),
        "OCCLUSION_QUERY_RESULT_NORESULT".enum("Query result is not available yet."),

        "OCCLUSION_QUERY_RESULT_COUNT".enum
    )

    EnumConstant(
        "{@code bgfx_topology}",

        "TOPOLOGY_TRI_LIST".enum("Triangle list"),
        "TOPOLOGY_TRI_STRIP".enum("Triangle strip"),
        "TOPOLOGY_LINE_LIST".enum("Line list"),
        "TOPOLOGY_LINE_STRIP".enum("Line strip"),
        "TOPOLOGY_POINT_LIST".enum("Point list"),

        "TOPOLOGY_COUNT".enum
    )

    val TopologyConvert = EnumConstant(
        "Topology conversion function ({@code bgfx_topology_convert_t}).",

        "TOPOLOGY_CONVERT_TRI_LIST_FLIP_WINDING".enum("Flip winding order of triangle list."),
        "TOPOLOGY_CONVERT_TRI_STRIP_FLIP_WINDING".enum("Flip winding order of triangle strip."),
        "TOPOLOGY_CONVERT_TRI_LIST_TO_LINE_LIST".enum("Convert triangle list to line list."),
        "TOPOLOGY_CONVERT_TRI_STRIP_TO_TRI_LIST".enum("Convert triangle strip to triangle list."),
        "TOPOLOGY_CONVERT_LINE_STRIP_TO_LINE_LIST".enum("Convert line strip to line list."),

        "TOPOLOGY_CONVERT_COUNT".enum
    ).javaDocLinksSkipCount

    val TopologySort = EnumConstant(
        "Topology sort order ({@code bgfx_topology_sort_t}).",

        "TOPOLOGY_SORT_DIRECTION_FRONT_TO_BACK_MIN".enum,
        "TOPOLOGY_SORT_DIRECTION_FRONT_TO_BACK_AVG".enum,
        "TOPOLOGY_SORT_DIRECTION_FRONT_TO_BACK_MAX".enum,
        "TOPOLOGY_SORT_DIRECTION_BACK_TO_FRONT_MIN".enum,
        "TOPOLOGY_SORT_DIRECTION_BACK_TO_FRONT_AVG".enum,
        "TOPOLOGY_SORT_DIRECTION_BACK_TO_FRONT_MAX".enum,
        "TOPOLOGY_SORT_DISTANCE_FRONT_TO_BACK_MIN".enum,
        "TOPOLOGY_SORT_DISTANCE_FRONT_TO_BACK_AVG".enum,
        "TOPOLOGY_SORT_DISTANCE_FRONT_TO_BACK_MAX".enum,
        "TOPOLOGY_SORT_DISTANCE_BACK_TO_FRONT_MIN".enum,
        "TOPOLOGY_SORT_DISTANCE_BACK_TO_FRONT_AVG".enum,
        "TOPOLOGY_SORT_DISTANCE_BACK_TO_FRONT_MAX".enum,

        "TOPOLOGY_SORT_COUNT".enum
    ).javaDocLinksSkipCount

    val ViewMode = EnumConstant(
        "View mode sets draw call sort order ({@code bgfx_view_mode_t}).",

        "VIEW_MODE_DEFAULT".enum("Default sort order."),
        "VIEW_MODE_SEQUENTIAL".enum("Sort in the same order in which submit calls were called."),
        "VIEW_MODE_DEPTH_ASCENDING".enum("Sort draw call depth in ascending order."),
        "VIEW_MODE_DEPTH_DESCENDING".enum("Sort draw call depth in descending order."),

        "VIEW_MODE_COUNT".enum
    ).javaDocLinksSkipCount

    void(
        "attachment_init",
        "Init attachment.",

        bgfx_attachment_t.p("_this", ""),
        bgfx_texture_handle_t("_handle", "render target texture handle"),
        bgfx_access_t("_access", "access", Access),
        MapToInt..uint16_t("_layer", "cubemap side or depth layer/slice to use"),
        MapToInt..uint16_t("_numLayers", "number of texture layer/slice(s) in array to use"),
        MapToInt..uint16_t("_mip", "mip level"),
        MapToInt..uint8_t("_resolve", "resolve flags", "RESOLVE_\\w+")
    )

    bgfx_vertex_layout_t.p(
        "vertex_layout_begin",
        "Start a vertex layout.",

        bgfx_vertex_layout_t.p("_this", "the vertex layout"),
        bgfx_renderer_type_t("_renderer", "the renderer backend type", RendererType),

        returnDoc = "itself"
    )

    bgfx_vertex_layout_t.p(
        "vertex_layout_add",
        """
        Adds attribute to a vertex layout.

        Must be called between #vertex_layout_begin()/#vertex_layout_end().
        """,

        bgfx_vertex_layout_t.p("_this", "the vertex layout"),
        bgfx_attrib_t("_attrib", "attribute semantics", Attrib),
        MapToInt..uint8_t("_num", "number of elements", "1 2 3 4"),
        bgfx_attrib_type_t("_type", "element type", AttribType),
        bool(
            "_normalized",
            """
            when using fixed point attribute type (f.e. #ATTRIB_TYPE_UINT8) value will be normalized for vertex shader usage. When {@code normalized} is set to
            true, #ATTRIB_TYPE_UINT8 value in range 0-255 will be in range 0.0-1.0 in vertex shader.
            """
        ),
        bool(
            "_asInt",
            """
            packaging rule for {@code vertexPack}, {@code vertexUnpack}, and {@code vertexConvert} for #ATTRIB_TYPE_UINT8 and #ATTRIB_TYPE_INT16. Unpacking
            code must be implemented inside vertex shader.
            """
        ),

        returnDoc = "itself"
    )

    void(
        "vertex_layout_decode",
        "Decodes attribute.",

        bgfx_vertex_layout_t.const.p("_this", "the vertex layout"),
        bgfx_attrib_t("_attrib", "the attribute to decode"),
        Check(1)..uint8_t.p("_num", "number of elements"),
        Check(1)..bgfx_attrib_type_t.p("_type", "element type"),
        Check(1)..bool.p("_normalized", "normalized flag"),
        Check(1)..bool.p("_asInt", "packaging flag")
    )

    bool(
        "vertex_layout_has",
        "Returns true if {@code _this} contains attribute.",

        bgfx_vertex_layout_t.const.p("_this", "the vertex layout"),
        bgfx_attrib_t("_attr", "the attribute to query", Attrib),

        returnDoc = "{@code true} if {@code VertexLayout} contains attribute"
    )

    bgfx_vertex_layout_t.p(
        "vertex_layout_skip",
        "Skips {@code _num} bytes in vertex stream.",

        bgfx_vertex_layout_t.p("_this", "the vertex layout"),
        MapToInt..uint8_t("_num", "the number of bytes to skip"),

        returnDoc = "itself"
    )

    void(
        "vertex_layout_end",
        "Ends a vertex layout.",

        bgfx_vertex_layout_t.p("_this", "the vertex layout")
    )

    void(
        "vertex_pack",
        "Packs vertex attribute into vertex stream format.",

        Check(4)..float.const.p("_input", "value to be packed into vertex stream"),
        bool("_inputNormalized", "true if input value is already normalized"),
        bgfx_attrib_t("_attr", "attribute to pack", Attrib),
        bgfx_vertex_layout_t.const.p("_layout", "vertex stream layout"),
        Unsafe..void.p("_data", "destination vertex stream where data will be packed"),
        uint32_t("_index", "vertex index that will be modified")
    )

    void(
        "vertex_unpack",
        "Unpacks vertex attribute from vertex stream format.",

        Check(4)..float.p("_output", "result of unpacking"),
        bgfx_attrib_t("_attr", "attribute to unpack", Attrib),
        bgfx_vertex_layout_t.const.p("_layout", "vertex stream layout"),
        Unsafe..void.const.p("_data", "source vertex stream from where data will be unpacked"),
        uint32_t("_index", "vertex index that will be unpacked")
    )

    void(
        "vertex_convert",
        "Converts vertex stream data from one vertex stream format to another.",

        bgfx_vertex_layout_t.const.p("_dstLayout", "destination vertex stream layout"),
        Unsafe..void.p("_dstData", "destination vertex stream"),
        bgfx_vertex_layout_t.const.p("_srcLayout", "source vertex stream layout"),
        Unsafe..void.const.p("_srcData", "source vertex stream data"),
        uint32_t("_num", "number of vertices to convert from source to destination")
    )

    uint32_t(
        "weld_vertices",
        "Welds vertices.",

        MultiType(
            PointerMapping.DATA_SHORT,
            PointerMapping.DATA_INT
        )..void.p("_output", "welded vertices remapping table. The size of buffer must be the same as number of vertices."),
        bgfx_vertex_layout_t.const.p("_layout", "vertex stream layout"),
        Unsafe..void.const.p("_data", "vertex stream"),
        AutoSizeShr("(_index32 ? 2 : 1)", "_output")..uint32_t("_num", "number of vertices in vertex stream"),
        bool("_index32", "set to {@code true} if input indices are 32-bit"),
        float("_epsilon", "error tolerance for vertex position comparison"),

        returnDoc = "number of unique vertices after vertex welding"
    )

    uint32_t(
        "topology_convert",
        "Converts index buffer for use with different primitive topologies.",

        bgfx_topology_convert_t("_conversion", "conversion type", TopologyConvert),
        MultiType(
            PointerMapping.DATA_SHORT,
            PointerMapping.DATA_INT
        )..nullable..void.p("_dst", "destination index buffer. If this argument is #NULL function will return number of indices after conversion"),
        AutoSize("_dst")..uint32_t(
            "_dstSize",
            """
            destination index buffer in bytes. It must be large enough to contain output indices. If destination size is insufficient index buffer will be
            truncated.
            """
        ),
        MultiType(
            PointerMapping.DATA_SHORT,
            PointerMapping.DATA_INT
        )..void.const.p("_indices", "source indices"),
        AutoSizeShr("(_index32 ? 2 : 1)", "_indices")..uint32_t("_numIndices", "number of input indices"),
        bool("_index32", "set to `true` if input indices are 32-bit"),

        returnDoc = "number of output indices after conversion"
    )

    void(
        "topology_sort_tri_list",
        "Sorts indices.",

        bgfx_topology_sort_t("_sort", "sort order", TopologySort),
        MultiType(
            PointerMapping.DATA_SHORT,
            PointerMapping.DATA_INT
        )..void.p("_dst", "destination index buffer"),
        AutoSize("_dst")..uint32_t(
            "_dstSize",
            """
            destination index buffer in bytes. It must be large enough to contain output indices. If destination size is insufficient index buffer will be
            truncated.
            """
        ),
        Check(3)..float.const.p("_dir", "direction (vector must be normalized)"),
        Check(3)..float.const.p("_pos", "position"),
        Unsafe..void.const.p(
            "_vertices",
            "pointer to first vertex represented as float x, y, z. Must contain at least number of vertices referenced by index buffer."
        ),
        uint32_t("_stride", "vertex stride"),
        MultiType(
            PointerMapping.DATA_SHORT,
            PointerMapping.DATA_INT
        )..void.const.p("_indices", "source indices"),
        AutoSizeShr("(_index32 ? 2 : 1)", "_indices")..uint32_t("_numIndices", "number of input indices"),
        bool("_index32", "set to `true` if input indices are 32-bit")
    )

    uint8_t(
        "get_supported_renderers",
        "Returns supported backend API renderers.",

        AutoSize("_enum")..MapToInt..uint8_t("_max", "maximum number of elements in {@code _enum} array"),
        bgfx_renderer_type_t.p("_enum", "array where supported renderers will be written"),

        returnDoc = "the number of renderers written to {@code _enum}"
    )

    charASCII.const.p(
        "get_renderer_name",
        "Returns name of renderer.",

        bgfx_renderer_type_t("_type", "the renderer type", RendererType)
    )

    void(
        "init_ctor",
        "Updates the specified initialization parameters with default values.",

        bgfx_init_t.p("_init", "initialization parameters")
    )

    bool(
        "init",
        "Initializes bgfx library.",

        bgfx_init_t.const.p("_init", "initialization parameters"),

        returnDoc = "true if initialization was successful"
    )

    void(
        "shutdown",
        "Shuts down bgfx library."
    )

    void(
        "reset",
        """
        Resets graphic settings and back-buffer size.

        This call doesn't actually change window size, it just resizes back-buffer. Windowing code has to change window size.
        """,

        uint32_t("_width", "back-buffer width"),
        uint32_t("_height", "back-buffer height"),
        uint32_t("_flags", "reset flags", ResetFlags, LinkMode.BITFIELD),
        bgfx_texture_format_t("_format", "texture format", TextureFormat)
    )

    uint32_t(
        "frame",
        """
        Advances to next frame. When using multithreaded renderer, this call just swaps internal buffers, kicks render thread, and returns. In singlethreaded
        renderer this call does frame rendering.
        """,

        bool("_capture", "capture frame with graphics debugger"),

        returnDoc =
        """
        current frame number. This might be used in conjunction with double/multi buffering data outside the library and passing it to library #make_ref()
        calls.
        """
    )

    bgfx_renderer_type_t(
        "get_renderer_type",
        "Returns current renderer backend API type.",
        void()
    )

    bgfx_caps_t.const.p(
        "get_caps",
        "Returns renderer capabilities.",
        void()
    )

    bgfx_stats_t.const.p(
        "get_stats",
        """
        Returns performance counters.

        The pointer returned is valid until #frame() is called.
        """,
        void()
    )

    bgfx_memory_t.const.p(
        "alloc",
        "Allocates buffer to pass to bgfx calls. Data will be freed inside bgfx.",

        uint32_t("_size", "the number of bytes to allocate")
    )

    bgfx_memory_t.const.p(
        "copy",
        "Allocates buffer and copies data into it. Data will be freed inside bgfx.",

        MultiTypeAll..void.const.p("_data", "pointer to data to be copied"),
        AutoSize("_data")..uint32_t("_size", "size of data to be copied")
    )

    OffHeapOnly..bgfx_memory_t.const.p(
        "make_ref",
        """
        Makes reference to data to pass to bgfx. Unlike #alloc(), this call doesn't allocate memory for data. It just copies the {@code _data} pointer.

        Data passed must be available for at least 2 #frame() calls.
        """,

        MultiTypeAll..void.const.p("_data", "the data to reference"),
        AutoSize("_data")..uint32_t("_size", "the number of bytes to reference")
    )

    OffHeapOnly..bgfx_memory_t.const.p(
        "make_ref_release",
        """
        Makes reference to data to pass to bgfx. Unlike #alloc(), this call doesn't allocate memory for data. It just copies the {@code _data} pointer.

        The {@code bgfx_release_fn_t} function pointer will release this memory after it's consumed. The {@code bgfx_release_fn_t} function must be able to be
        called from any thread.
        """,

        MultiTypeAll..void.const.p("_data", "the data to reference"),
        AutoSize("_data")..uint32_t("_size", "the number of bytes to reference"),
        bgfx_release_fn_t("_releaseFn", "callback function to release memory after use"),
        nullable..opaque_p("_userData", "user data to be passed to callback function")
    )

    void(
        "set_debug",
        "Sets debug flags.",

        uint32_t("_debug", "the debug flags", DebugFlags, LinkMode.BITFIELD)
    )

    void(
        "dbg_text_clear",
        "Clears internal debug text buffer.",

        MapToInt..uint8_t("_attr", "background color"),
        bool("_small", "default 8x16 or 8x8 font")
    )

    void(
        "dbg_text_printf",
        "Prints into internal debug text character-buffer (VGA-compatible text mode).",

        MapToInt..uint16_t("_x", "x coordinate"),
        MapToInt..uint16_t("_y", "y coordinate"),
        MapToInt..uint8_t(
            "_attr",
            """
            color palette. Where top 4-bits represent index of background, and bottom 4-bits represent foreground color from standard VGA text palette (ANSI
            escape codes).
            """
        ),
        charASCII.const.p("_format", "`printf` style format")
    )

    void(
        "dbg_text_vprintf",
        "Print into internal debug text character-buffer (VGA-compatible text mode).",

        MapToInt..uint16_t("_x", "x coordinate"),
        MapToInt..uint16_t("_y", "y coordinate"),
        MapToInt..uint8_t(
            "_attr",
            "color palette. Where top 4-bits represent index of background, and bottom 4-bits represent foreground color from standard VGA text palette."
        ),
        charASCII.const.p("_format", "`printf` style format"),
        va_list("_argList", "additional arguments for format string")
    )

    void(
        "dbg_text_image",
        "Draws image into internal debug text buffer.",

        MapToInt..uint16_t("_x", "x coordinate"),
        MapToInt..uint16_t("_y", "y coordinate"),
        MapToInt..uint16_t("_width", "image width"),
        MapToInt..uint16_t("_height", "image height"),
        Check("_height * _pitch")..void.const.p("_data", "raw image data (character/attribute raw encoding)"),
        MapToInt..uint16_t("_pitch", "image pitch in bytes")
    )

    bgfx_index_buffer_handle_t(
        "create_index_buffer",
        "Creates static index buffer.",

        bgfx_memory_t.const.p("_mem", "index buffer data"),
        MapToInt..uint16_t("_flags", "buffer creation flags", BufferFlags, LinkMode.BITFIELD)
    )

    void(
        "set_index_buffer_name",
        "Set static index buffer debug name.",

        bgfx_index_buffer_handle_t("_handle", "static index buffer handle"),
        charASCII.const.p("_name", "static index buffer name"),
        AutoSize("_name")..int32_t(
            "_len",
            "static index buffer name length (if length is {@code INT32_MAX}, it's expected that {@code _name} is zero terminated string)"
        )
    )

    void(
        "destroy_index_buffer",
        "Destroys static index buffer.",

        bgfx_index_buffer_handle_t("_handle", "the static index buffer to destroy")
    )

    bgfx_vertex_layout_handle_t(
        "create_vertex_layout",
        "Creates a vertex layout.",

        bgfx_vertex_layout_t.const.p("_layout", "vertex layout")
    )

    void(
        "destroy_vertex_layout",
        "Destroys a vertex layout.",

        bgfx_vertex_layout_handle_t("_handle", "vertex layout handle")
    )

    bgfx_vertex_buffer_handle_t(
        "create_vertex_buffer",
        "Creates static vertex buffer.",

        bgfx_memory_t.const.p("_mem", "vertex buffer data"),
        bgfx_vertex_layout_t.const.p("_layout", "vertex layout"),
        MapToInt..uint16_t("_flags", "buffer creation flags", BufferFlags, LinkMode.BITFIELD)
    )

    void(
        "set_vertex_buffer_name",
        "Set static vertex buffer debug name.",

        bgfx_vertex_buffer_handle_t("_handle", "static vertex buffer handle"),
        charASCII.const.p("_name", "static vertex buffer name"),
        AutoSize("_name")..int32_t(
            "_len",
            "static vertex buffer name length (if length is {@code INT32_MAX}, it's expected that {@code _name} is zero terminated string)"
        )
    )

    void(
        "destroy_vertex_buffer",
        "Destroys static vertex buffer.",

        bgfx_vertex_buffer_handle_t("_handle", "the static vertex buffer to destroy")
    )

    bgfx_dynamic_index_buffer_handle_t(
        "create_dynamic_index_buffer",
        "Creates empty dynamic index buffer.",

        uint32_t("_num", "number of indices"),
        MapToInt..uint16_t("_flags", "buffer creation flags", BufferFlags, LinkMode.BITFIELD)
    )

    bgfx_dynamic_index_buffer_handle_t(
        "create_dynamic_index_buffer_mem",
        "Creates dynamic index buffer and initializes it.",

        bgfx_memory_t.const.p("_mem", "index buffer data"),
        MapToInt..uint16_t("_flags", "buffer creation flags", BufferFlags, LinkMode.BITFIELD)
    )

    void(
        "update_dynamic_index_buffer",
        "Updates dynamic index buffer.",

        bgfx_dynamic_index_buffer_handle_t("_handle", "dynamic index buffer handle"),
        uint32_t("_startIndex", "start index"),
        bgfx_memory_t.const.p("_mem", "index buffer data")
    )

    void(
        "destroy_dynamic_index_buffer",
        "Destroys dynamic index buffer.",

        bgfx_dynamic_index_buffer_handle_t("_handle", "the dynamic index buffer to destroy")
    )

    bgfx_dynamic_vertex_buffer_handle_t(
        "create_dynamic_vertex_buffer",
        "Creates empty dynamic vertex buffer.",

        uint32_t("_num", "number of vertices"),
        bgfx_vertex_layout_t.const.p("_layout", "vertex layout"),
        MapToInt..uint16_t("_flags", "buffer creation flags", BufferFlags, LinkMode.BITFIELD)
    )

    bgfx_dynamic_vertex_buffer_handle_t(
        "create_dynamic_vertex_buffer_mem",
        "Creates dynamic vertex buffer and initializes it.",

        bgfx_memory_t.const.p("_mem", "vertex buffer data"),
        bgfx_vertex_layout_t.const.p("_layout", "vertex layout"),
        MapToInt..uint16_t("_flags", "buffer creation flags", BufferFlags, LinkMode.BITFIELD)
    )

    void(
        "update_dynamic_vertex_buffer",
        "Updates dynamic vertex buffer.",

        bgfx_dynamic_vertex_buffer_handle_t("_handle", "dynamic vertex buffer handle"),
        uint32_t("_startVertex", "start vertex"),
        bgfx_memory_t.const.p("_mem", "vertex buffer data")
    )

    void(
        "destroy_dynamic_vertex_buffer",
        "Destroys dynamic vertex buffer.",

        bgfx_dynamic_vertex_buffer_handle_t("_handle", "the dynamic vertex buffer to destroy")
    )

    uint32_t(
        "get_avail_transient_index_buffer",
        "Returns number of requested or maximum available indices.",

        uint32_t("_num", "number of required indices"),
        bool("_index32", "set to {@code true} if input indices will be 32-bit")
    )

    uint32_t(
        "get_avail_transient_vertex_buffer",
        "Returns number of requested or maximum available vertices.",

        uint32_t("_num", "number of required vertices"),
        bgfx_vertex_layout_t.const.p("_layout", "vertex layout")
    )

    uint32_t(
        "get_avail_instance_data_buffer",
        "Returns number of requested or maximum available instance buffer slots.",

        uint32_t("_num", "number of required instances"),
        MapToInt..uint16_t("_stride", "stride per instance")
    )

    void(
        "alloc_transient_index_buffer",
        "Allocates transient index buffer.",

        bgfx_transient_index_buffer_t.p(
            "_tib",
            "##BGFXTransientIndexBuffer structure is filled and is valid for the duration of frame, and it can be reused for multiple draw calls"
        ),
        uint32_t("_num", "number of indices to allocate"),
        bool("_index32", "set to {@code true} if input indices will be 32-bit")
    )

    void(
        "alloc_transient_vertex_buffer",
        "Allocates transient vertex buffer.",

        bgfx_transient_vertex_buffer_t.p(
            "_tvb",
            "##BGFXTransientVertexBuffer structure is filled and is valid for the duration of frame, and it can be reused for multiple draw calls"
        ),
        uint32_t("_num", "number of vertices to allocate"),
        bgfx_vertex_layout_t.const.p("_layout", "vertex layout")
    )

    bool(
        "alloc_transient_buffers",
        "Checks for required space and allocates transient vertex and index buffers. If both space requirements are satisfied function returns true.",

        bgfx_transient_vertex_buffer_t.p(
            "_tvb",
            "##BGFXTransientVertexBuffer structure is filled and is valid for the duration of frame, and it can be reused for multiple draw calls"
        ),
        bgfx_vertex_layout_t.const.p("_layout", "vertex layout"),
        uint32_t("_numVertices", "number of vertices to allocate"),
        bgfx_transient_index_buffer_t.p(
            "_tib",
            "##BGFXTransientIndexBuffer structure is filled and is valid for the duration of frame, and it can be reused for multiple draw calls"
        ),
        uint32_t("_numIndices", "number of indices to allocate"),
        bool("_index32", "set to {@code true} if input indices will be 32-bit")
    )

    void(
        "alloc_instance_data_buffer",
        "Allocates instance data buffer.",

        bgfx_instance_data_buffer_t.p(
            "_idb",
            "##BGFXInstanceDataBuffer structure is filled and is valid for duration of frame, and it can be reused for multiple draw calls"
        ),
        uint32_t("_num", "number of instances"),
        MapToInt..uint16_t("_stride", "instance stride. Must be multiple of 16")
    )

    bgfx_indirect_buffer_handle_t(
        "create_indirect_buffer",
        "Creates draw indirect buffer.",

        uint32_t("_num", "number of indirect calls")
    )

    void(
        "destroy_indirect_buffer",
        "Destroys draw indirect buffer.",

        bgfx_indirect_buffer_handle_t("_handle", "the draw indirect buffer to destroy")
    )

    bgfx_shader_handle_t(
        "create_shader",
        "Creates shader from memory buffer.",

        bgfx_memory_t.const.p("_mem", ""),

        returnDoc = "shader handle"
    )

    uint16_t(
        "get_shader_uniforms",
        """
        Returns the number of uniforms and uniform handles used inside shader.

        Only non-predefined uniforms are returned.
        """,

        bgfx_shader_handle_t("_handle", "shader handle"),
        bgfx_uniform_handle_t.p("_uniforms", "{@code bgfx_uniform_handle_t} array where data will be stored"),
        AutoSize("_uniforms")..uint16_t("_max", "maximum capacity of {@code _uniforms}"),

        returnDoc = "number of uniforms used by shader"
    )

    void(
        "set_shader_name",
        "Sets shader debug name.",

        bgfx_shader_handle_t("_handle", "shader handle"),
        charUTF8.const.p("_name", "shader name"),
        AutoSize("_name")..int32_t(
            "_len",
            "shader name length (if length is {@code INT32_MAX}, it's expected that {@code _name} is zero terminated string)"
        )
    )

    void(
        "destroy_shader",
        "Destroys shader. Once a shader program is created with {@code _handle}, it is safe to destroy that shader.",

        bgfx_shader_handle_t("_handle", "the shader  to destroy")
    )

    bgfx_program_handle_t(
        "create_program",
        "Creates program with vertex and fragment shaders.",

        bgfx_shader_handle_t("_vsh", "vertex shader"),
        bgfx_shader_handle_t("_fsh", "fragment shader"),
        bool("_destroyShaders", "if true, shaders will be destroyed when program is destroyed"),

        returnDoc = "program handle if vertex shader output and fragment shader input are matching, otherwise returns invalid program handle."
    )

    bgfx_program_handle_t(
        "create_compute_program",
        "Creates program with compute shader.",

        bgfx_shader_handle_t("_csh", "compute shader"),
        bool("_destroyShaders", "if true, shader will be destroyed when program is destroyed")
    )

    void(
        "destroy_program",
        "Destroy program.",

        bgfx_program_handle_t("_handle", "the program to destroy")
    )

    bool(
        "is_texture_valid",
        "Validate texture parameters.",

        MapToInt..uint16_t("_depth", "depth dimension of volume texture"),
        bool("_cubeMap", "indicates that texture contains cubemap"),
        MapToInt..uint16_t("_numLayers", "number of layers in texture array"),
        bgfx_texture_format_t("_format", "texture format", TextureFormat),
        uint64_t("_flags", "texture flags", TextureFlags, LinkMode.BITFIELD),

        returnDoc = "true if texture can be successfully created"
    )

    bool(
        "is_frame_buffer_valid",
        "Validate frame buffer parameters.",

        MapToInt..uint8_t("_num", "number of attachments"),
        bgfx_attachment_t.const.p("_attachment", "attachment texture info"),

        returnDoc = "true if frame buffer can be successfully created"
    )

    void(
        "calc_texture_size",
        "Calculates amount of memory required for texture.",

        bgfx_texture_info_t_p("_info", "resulting texture info structure"),
        MapToInt..uint16_t("_width", "width"),
        MapToInt..uint16_t("_height", "height"),
        MapToInt..uint16_t("_depth", "depth dimension of volume texture"),
        bool("_cubeMap", "indicates that texture contains cubemap"),
        bool("_hasMips", "indicates that texture contains full mip-map chain"),
        MapToInt..uint16_t("_numLayers", "number of layers in texture array"),
        bgfx_texture_format_t("_format", "texture format", TextureFormat)
    )

    bgfx_texture_handle_t(
        "create_texture",
        "Creates texture from memory buffer.",

        bgfx_memory_t.const.p("_mem", "DDS, KTX or PVR texture data"),
        uint64_t(
            "_flags",
            "texture creation and sampler flags. Default texture sampling mode is linear, and wrap mode is repeat.",
            "$TextureFlags $SamplerFlags", LinkMode.BITFIELD
        ),
        MapToInt..uint8_t("_skip", "skip top level mips when parsing texture"),
        nullable..bgfx_texture_info_t_p("_info", "when non-#NULL is specified it returns parsed texture information")
    )

    bgfx_texture_handle_t(
        "create_texture_2d",
        "Creates 2D texture.",

        MapToInt..uint16_t("_width", "width"),
        MapToInt..uint16_t("_height", "height"),
        bool("_hasMips", "indicates that texture contains full mip-map chain"),
        MapToInt..uint16_t("_numLayers", "number of layers in texture array. Must be 1 if caps #CAPS_TEXTURE_2D_ARRAY flag is not set."),
        bgfx_texture_format_t("_format", "texture format", TextureFormat),
        uint64_t(
            "_flags",
            "texture creation and sampler flags. Default texture sampling mode is linear, and wrap mode is repeat.",
            "$TextureFlags $SamplerFlags", LinkMode.BITFIELD
        ),
        nullable..bgfx_memory_t.const.p(
            "_mem",
            """
            texture data. If {@code _mem} is non-#NULL, created texture will be immutable. When {@code _numLayers} is more than 1, expected memory layout is
            texture and all mips together for each array element.
            """
        )
    )

    bgfx_texture_handle_t(
        "create_texture_2d_scaled",
        "Creates texture with size based on backbuffer ratio. Texture will maintain ratio if back buffer resolution changes.",

        bgfx_backbuffer_ratio_t("_ratio", "frame buffer size in respect to back-buffer size", BackbufferRatio),
        bool("_hasMips", "indicates that texture contains full mip-map chain"),
        MapToInt..uint16_t("_numLayers", "number of layers in texture array. Must be 1 if caps #CAPS_TEXTURE_2D_ARRAY flag is not set."),
        bgfx_texture_format_t("_format", "texture format", TextureFormat),
        uint64_t(
            "_flags",
            "texture creation and sampler flags. Default texture sampling mode is linear, and wrap mode is repeat.",
            "$TextureFlags $SamplerFlags", LinkMode.BITFIELD
        )
    )

    bgfx_texture_handle_t(
        "create_texture_3d",
        "Creates 3D texture.",

        MapToInt..uint16_t("_width", "width"),
        MapToInt..uint16_t("_height", "height"),
        MapToInt..uint16_t("_depth", "depth"),
        bool("_hasMips", "indicates that texture contains full mip-map chain"),
        bgfx_texture_format_t("_format", "texture format", TextureFormat),
        uint64_t(
            "_flags",
            "texture creation and sampler flags. Default texture sampling mode is linear, and wrap mode is repeat.",
            "$TextureFlags $SamplerFlags", LinkMode.BITFIELD
        ),
        nullable..bgfx_memory_t.const.p("_mem", "texture data. If {@code _mem} is non-#NULL, created texture will be immutable.")
    )

    bgfx_texture_handle_t(
        "create_texture_cube",
        "Creates Cube texture.",

        MapToInt..uint16_t("_size", "cube side size"),
        bool("_hasMips", "indicates that texture contains full mip-map chain"),
        MapToInt..uint16_t("_numLayers", "number of layers in texture array. Must be 1 if caps #CAPS_TEXTURE_CUBE_ARRAY flag is not set."),
        bgfx_texture_format_t("_format", "", TextureFormat),
        uint64_t(
            "_flags",
            "texture creation and sampler flags. Default texture sampling mode is linear, and wrap mode is repeat.",
            "$TextureFlags $SamplerFlags", LinkMode.BITFIELD
        ),
        nullable..bgfx_memory_t.const.p(
            "_mem",
            """
            texture data. If {@code _mem} is non-#NULL, created texture will be immutable. When {@code _numLayers} is more than 1, expected memory layout is
            cubemap texture and all mips together for each array element.
            """
        )
    )

    void(
        "update_texture_2d",
        """
        Updates 2D texture.

        It's valid to update only mutable texture. See #create_texture_2d() for more info.
        """,

        bgfx_texture_handle_t("_handle", "texture handle"),
        MapToInt..uint16_t("_layer", "layers in texture array"),
        MapToInt..uint8_t("_mip", "mip level"),
        MapToInt..uint16_t("_x", "x offset in texture"),
        MapToInt..uint16_t("_y", "y offset in texture"),
        MapToInt..uint16_t("_width", "width of texture block"),
        MapToInt..uint16_t("_height", "height of texture block"),
        bgfx_memory_t.const.p("_mem", "texture update data"),
        MapToInt..uint16_t(
            "_pitch",
            "pitch of input image (bytes). When {@code _pitch} is set to {@code UINT16_MAX}, it will be calculated internally based on {@code _width}."
        )
    )

    void(
        "update_texture_3d",
        """
        Updates 3D texture.

        It's valid to update only mutable texture. See #create_texture_3d() for more info.
        """,

        bgfx_texture_handle_t("_handle", "texture handle"),
        MapToInt..uint8_t("_mip", "mip level"),
        MapToInt..uint16_t("_x", "x offset in texture"),
        MapToInt..uint16_t("_y", "y offset in texture"),
        MapToInt..uint16_t("_z", "z offset in texture"),
        MapToInt..uint16_t("_width", "width of texture block"),
        MapToInt..uint16_t("_height", "height of texture block"),
        MapToInt..uint16_t("_depth", "depth of texture block"),
        bgfx_memory_t.const.p("_mem", "texture update data")
    )

    void(
        "update_texture_cube",
        """
        Updates Cube texture.

        It's valid to update only mutable texture. See #create_texture_cube() for more info.
        """,

        bgfx_texture_handle_t("_handle", "texture handle"),
        MapToInt..uint16_t("_layer", "layers in texture array"),
        uint8_t(
            "_side",
            """
            cubemap side, where 0 is +X, 1 is -X, 2 is +Y, 3 is -Y, 4 is +Z, and 5 is -Z.
            ${codeBlock("""
           +----------+
           |-z       2|
           | ^  +y    |
           | |        |    Unfolded cube:
           | +---->+x |
+----------+----------+----------+----------+
|+y       1|+y       4|+y       0|+y       5|
| ^  -x    | ^  +z    | ^  +x    | ^  -z    |
| |        | |        | |        | |        |
| +---->+z | +---->+x | +---->-z | +---->-x |
+----------+----------+----------+----------+
           |+z       3|
           | ^  -y    |
           | |        |
           | +---->+x |
           +----------+""")}
            """,
            CubeMapSides
        ),
        MapToInt..uint8_t("_mip", "mip level"),
        MapToInt..uint16_t("_x", "x offset in texture"),
        MapToInt..uint16_t("_y", "y offset in texture"),
        MapToInt..uint16_t("_width", "width of texture block"),
        MapToInt..uint16_t("_height", "height of texture block"),
        bgfx_memory_t.const.p("_mem", "texture update data"),
        MapToInt..uint16_t(
            "_pitch",
            "pitch of input image (bytes). When {@code _pitch} is set to {@code UINT16_MAX}, it will be calculated internally based on {@code _width}."
        )
    )

    uint32_t(
        "read_texture",
        """
        Reads back texture content.

        Texture must be created with #TEXTURE_READ_BACK flag. Availability depends on #CAPS_TEXTURE_READ_BACK.
        """,

        bgfx_texture_handle_t("_handle", "texture handle"),
        MultiType(
            PointerMapping.DATA_SHORT,
            PointerMapping.DATA_INT,
            PointerMapping.DATA_FLOAT
        )..Unsafe..void.p("_data", "destination buffer"),
        MapToInt..uint8_t("_mip", "mip level"),

        returnDoc = "frame number when the result will be available"
    )

    void(
        "set_texture_name",
        "Sets texture debug name.",

        bgfx_texture_handle_t("_handle", "texture handle"),
        charUTF8.const.p("_name", "texture name"),
        AutoSize("_name")..int32_t(
            "_len",
            "texture name length (if length is {@code INT32_MAX}, it's expected that {@code _name} is zero terminated string)"
        )
    )

    opaque_p(
        "get_direct_access_ptr",
        """
        Returns texture direct access pointer.

        Returns pointer to texture memory. If returned pointer is #NULL direct access is not available for this texture. If pointer is {@code UINTPTR_MAX}
        sentinel value it means texture is pending creation. Pointer returned can be cached and it will be valid until texture is destroyed.

        ${note(
            "Availability depends on: #CAPS_TEXTURE_DIRECT_ACCESS. This feature is available on GPUs that have unified memory architecture (UMA) support."
        )}
        """,

        bgfx_texture_handle_t("_handle", "")
    )

    void(
        "destroy_texture",
        "Destroys texture.",

        bgfx_texture_handle_t("_handle", "texture handle")
    )

    bgfx_frame_buffer_handle_t(
        "create_frame_buffer",
        "Creates frame buffer (simple).",

        MapToInt..uint16_t("_width", "texture width"),
        MapToInt..uint16_t("_height", "texture height"),
        bgfx_texture_format_t("_format", "texture format", TextureFormat),
        uint64_t("_textureFlags", "default texture sampling mode is linear, and wrap mode is repeat", "$TextureFlags $SamplerFlags"),

        returnDoc = "handle to frame buffer object"
    )

    bgfx_frame_buffer_handle_t(
        "create_frame_buffer_scaled",
        "Creates frame buffer with size based on backbuffer ratio. Frame buffer will maintain ratio if back buffer resolution changes.",

        bgfx_backbuffer_ratio_t("_ratio", "frame buffer size in respect to back-buffer size", BackbufferRatio),
        bgfx_texture_format_t("_format", "texture format", TextureFormat),
        uint64_t("_textureFlags", "default texture sampling mode is linear, and wrap mode is repeat", "$TextureFlags $SamplerFlags"),

        returnDoc = "handle to frame buffer object"
    )

    bgfx_frame_buffer_handle_t(
        "create_frame_buffer_from_handles",
        "Creates MRT frame buffer from texture handles (simple).",

        AutoSize("_handles")..uint8_t("_num", "number of texture attachments"),
        bgfx_texture_handle_t.const.p("_handles", "texture attachments"),
        bool("_destroyTextures", "if true, textures will be destroyed when frame buffer is destroyed"),

        returnDoc = "handle to frame buffer object"
    )

    bgfx_frame_buffer_handle_t(
        "create_frame_buffer_from_attachment",
        "Create MRT frame buffer from texture handles with specific layer and mip level.",

        AutoSize("_attachment")..uint8_t("_num", "number of attachments"),
        bgfx_attachment_t.const.p("_attachment", "attachment texture info"),
        bool("_destroyTextures", "if true, textures will be destroyed when frame buffer is destroyed"),

        returnDoc = "handle to frame buffer object"
    )

    bgfx_frame_buffer_handle_t(
        "create_frame_buffer_from_nwh",
        """
        Creates frame buffer for multiple window rendering.

        Frame buffer cannot be used for sampling.
        """,

        opaque_p("_nwh", "OS' target native window handle"),
        MapToInt..uint16_t("_width", "window back buffer width"),
        MapToInt..uint16_t("_height", "window back buffer height"),
        bgfx_texture_format_t("_format", "window back buffer color format", TextureFormat),
        bgfx_texture_format_t("_depthFormat", "window back buffer depth format", TextureFormat),

        returnDoc = "handle to frame buffer object"
    )

    void(
        "set_frame_buffer_name",
        "Set frame buffer debug name.",

        bgfx_frame_buffer_handle_t("_handle", "frame buffer handle"),
        charASCII.const.p("_name", "frame buffer name"),
        AutoSize("_name")..int32_t(
            "_len",
            "frame buffer name length (if length is {@code INT32_MAX}, it's expected that {@code _name} is zero terminated string)"
        )
    )

    bgfx_texture_handle_t(
        "get_texture",
        "Obtains texture handle of frame buffer attachment.",

        bgfx_frame_buffer_handle_t("_handle", "frame buffer handle"),
        MapToInt..uint8_t("_attachment", "frame buffer attachment index"),

        returnDoc = "invalid texture handle if attachment index is not correct, or frame buffer is created with native window handle"
    )

    void(
        "destroy_frame_buffer",
        "Destroys frame buffer.",

        bgfx_frame_buffer_handle_t("_handle", "the frame buffer to destroy")
    )

    bgfx_uniform_handle_t(
        "create_uniform",
        """
        Creates shader uniform parameter.

        Uniform names are unique. It's valid to call {@code bgfx_create_uniform} multiple times with the same uniform name. The library will always return the
        same handle, but the handle reference count will be incremented. This means that the same number of #destroy_uniform() must be called to properly
        destroy the uniform.

        Predefined uniforms (declared in `bgfx_shader.sh`):
        ${ul(
            "{@code u_viewRect vec4(x, y, width, height)} - view rectangle for current view, in pixels.",
            "{@code u_viewTexel vec4(1.0/width, 1.0/height, undef, undef)} - inverse width and height",
            "{@code u_view mat4} - view matrix",
            "{@code u_invView mat4} - inverted view matrix",
            "{@code u_proj mat4} - projection matrix",
            "{@code u_invProj mat4} - inverted projection matrix",
            "{@code u_viewProj mat4} - concatenated view projection matrix",
            "{@code u_invViewProj mat4} - concatenated inverted view projection matrix",
            "{@code u_model mat4[BGFX_CONFIG_MAX_BONES]} - array of model matrices.",
            "{@code u_modelView mat4} - concatenated model view matrix, only first model matrix from array is used.",
            "{@code u_modelViewProj mat4} - concatenated model view projection matrix.",
            "{@code u_alphaRef float} - alpha reference value for alpha test."
        )}
        """,

        charASCII.const.p("_name", "uniform name in shader"),
        bgfx_uniform_type_t("_type", "type of uniform", UniformType),
        MapToInt..uint16_t("_num", "number of elements in array"),

        returnDoc = "handle to uniform object"
    )

    void(
        "get_uniform_info",
        "Retrieves uniform info.",

        bgfx_uniform_handle_t("_handle", "handle to uniform object"),
        bgfx_uniform_info_t_p("_info", "uniform info")
    )

    void(
        "destroy_uniform",
        "Destroys shader uniform parameter.",

        bgfx_uniform_handle_t("_handle", "handle to uniform object")
    )

    bgfx_occlusion_query_handle_t(
        "create_occlusion_query",
        "Creates occlusion query.",

        returnDoc = "handle to occlusion query object"
    )

    bgfx_occlusion_query_result_t(
        "get_result",
        "Retrieves occlusion query result from previous frame.",

        bgfx_occlusion_query_handle_t("_handle", "handle to occlusion query object"),
        Check(1)..nullable..int32_t.p(
            "_result",
            "number of pixels that passed test. This argument can be #NULL if result of occlusion query is not needed."
        ),

        returnDoc = "occlusion query result"
    )

    void(
        "destroy_occlusion_query",
        "Destroys occlusion query.",

        bgfx_occlusion_query_handle_t("_handle", "handle to occlusion query object")
    )

    void(
        "set_palette_color",
        "Sets palette color value.",

        MapToInt..uint8_t("_index", "index into palette"),
        Check(4)..float.const.p("_rgba", "RGBA floating point values")
    )

    void(
        "set_palette_color_rgba8",
        "Sets palette color value.",

        MapToInt..uint8_t("_index", "index into palette"),
        uint32_t("_rgba", "packed 32-bit RGBA value")
    )

    void(
        "set_view_name",
        """
        Sets view name.

        This is debug only feature. In graphics debugger view name will appear as:
        ${codeBlock("""
"nnnce <view name>"
 ^  ^^ ^
 |  |+-- eye (L/R)
 |  +--- compute (C)
 +------ view id""")}
        """,

        MapToInt..bgfx_view_id_t("_id", "view id"),
        charASCII.const.p("_name", "view name")
    )

    void(
        "set_view_rect",
        "Sets view rectangle. Draw primitive outside view will be clipped.",

        MapToInt..bgfx_view_id_t("_id", "view id"),
        MapToInt..uint16_t("_x", "position x from the left corner of the window"),
        MapToInt..uint16_t("_y", "position y from the top corner of the window"),
        MapToInt..uint16_t("_width", "width of view port region"),
        MapToInt..uint16_t("_height", "height of view port region")
    )

    void(
        "set_view_rect_ratio",
        "Sets view rectangle. Draw primitive outside view will be clipped.",

        MapToInt..bgfx_view_id_t("_id", "view id"),
        MapToInt..uint16_t("_x", "position x from the left corner of the window"),
        MapToInt..uint16_t("_y", "position y from the top corner of the window"),
        bgfx_backbuffer_ratio_t("_ratio", "width and height will be set in respect to back-buffer size", BackbufferRatio)
    )

    void(
        "set_view_scissor",
        """
        Sets view scissor. Draw primitive outside view will be clipped. When {@code _x}, {@code _y}, {@code _width} and {@code _height} are set to 0, scissor
        will be disabled.
        """,

        MapToInt..bgfx_view_id_t("_id", "view id"),
        MapToInt..uint16_t("_x", "position x from the left corner of the window"),
        MapToInt..uint16_t("_y", "position y from the top corner of the window"),
        MapToInt..uint16_t("_width", "width of scissor region"),
        MapToInt..uint16_t("_height", "height of scissor region")
    )

    void(
        "set_view_clear",
        "Sets view clear flags.",

        MapToInt..bgfx_view_id_t("_id", "view id"),
        MapToInt..uint16_t("_flags", "clear flags. Use #CLEAR_NONE to remove any clear operation.", ClearFlags, LinkMode.BITFIELD),
        uint32_t("_rgba", "color clear value"),
        float("_depth", "depth clear value"),
        MapToInt..uint8_t("_stencil", "stencil clear value")
    )

    void(
        "set_view_clear_mrt",
        "Sets view clear flags with different clear color for each frame buffer texture. Must use #set_palette_color() to setup clear color palette.",

        MapToInt..bgfx_view_id_t("_id", "view id"),
        MapToInt..uint16_t("_flags", "clear flags. Use #CLEAR_NONE to remove any clear operation.", ClearFlags, LinkMode.BITFIELD),
        float("_depth", "depth clear value"),
        MapToInt..uint8_t("_stencil", "stencil clear value"),
        uint8_t("_0", "palette index for frame buffer attachment 0"),
        uint8_t("_1", "palette index for frame buffer attachment 1"),
        uint8_t("_2", "palette index for frame buffer attachment 2"),
        uint8_t("_3", "palette index for frame buffer attachment 3"),
        uint8_t("_4", "palette index for frame buffer attachment 4"),
        uint8_t("_5", "palette index for frame buffer attachment 5"),
        uint8_t("_6", "palette index for frame buffer attachment 6"),
        uint8_t("_7", "palette index for frame buffer attachment 7")
    )

    void(
        "set_view_mode",
        "Sets view sorting mode.",

        MapToInt..bgfx_view_id_t("_id", "view id"),
        bgfx_view_mode_t("_mode", "view sort mode", ViewMode)
    )

    void(
        "set_view_frame_buffer",
        """
        Sets view frame buffer.

        Not persistent after #reset() call.
        """,

        MapToInt..bgfx_view_id_t("_id", "view id"),
        bgfx_frame_buffer_handle_t(
            "_handle",
            "frame buffer handle. Passing #INVALID_HANDLE as frame buffer handle will draw primitives from this view into default back buffer."
        )
    )

    void(
        "set_view_transform",
        "Sets view view and projection matrices, all draw primitives in this view will use these matrices.",

        MapToInt..bgfx_view_id_t("_id", "view id"),
        MultiType(
            PointerMapping.DATA_FLOAT
        )..Check(4 x 4 x 4)..nullable..void.const.p("_view", "view matrix"),
        MultiType(
            PointerMapping.DATA_FLOAT
        )..Check(4 x 4 x 4)..nullable..void.const.p("_proj", "projection matrix")
    )

    void(
        "set_view_order",
        "Post submit view reordering.",

        MapToInt..bgfx_view_id_t("_id", "view id"),
        MapToInt..uint16_t("_num", "number of views to remap"),
        Check("_num")..nullable..bgfx_view_id_t.const.p("_order", "view remap id table. Passing #NULL will reset view ids to default state")
    )

    void(
        "reset_view",
        "Reset all view settings to default.",

        MapToInt..bgfx_view_id_t("_id", "view id")
    )

    bgfx_encoder_s.p(
        "encoder_begin",
        "Begin submitting draw calls from thread.",

        bool("_forThread", "explicitly request an encoder for a worker thread"),

        returnDoc = "an encoder for submitting draw calls from multiple threads"
    )

    void(
        "encoder_end",
        "End submitting draw calls from thread.",

        bgfx_encoder_s.p("_encoder", "the encoder")
    )

    void(
        "encoder_set_marker",
        "Sets debug marker.",

        bgfx_encoder_s.p("_this", "the encoder"),
        charASCII.const.p("_marker", "debug marker")
    )

    void(
        "encoder_set_state",
        """
        Sets render states for draw primitive.

        Remarks:
        ${ol(
            """
            To setup more complex states use:
            ${codeBlock("""
BGFX_STATE_ALPHA_REF(_ref),
BGFX_STATE_POINT_SIZE(_size),
BGFX_STATE_BLEND_FUNC(_src, _dst),
BGFX_STATE_BLEND_FUNC_SEPARATE(_srcRGB, _dstRGB, _srcA, _dstA)
BGFX_STATE_BLEND_EQUATION(_equation)
BGFX_STATE_BLEND_EQUATION_SEPARATE(_equationRGB, _equationA)""")}
            """,
            "#STATE_BLEND_EQUATION_ADD is set when no other blend equation is specified."
        )}
        """,

        bgfx_encoder_s.p("_this", "the encoder"),
        uint64_t("_state", "state flags", StateFlags, LinkMode.BITFIELD),
        uint32_t("_rgba", "blend factor used by #STATE_BLEND_FACTOR and #STATE_BLEND_INV_FACTOR blend modes")
    )

    void(
        "encoder_set_condition",
        "Sets condition for rendering.",

        bgfx_encoder_s.p("_this", "the encoder"),
        bgfx_occlusion_query_handle_t("_handle", "occlusion query handle"),
        bool("_visible", "render if occlusion query is visible")
    )

    void(
        "encoder_set_stencil",
        "Sets stencil test state.",

        bgfx_encoder_s.p("_this", "the encoder"),
        uint32_t("_fstencil", "front stencil state", StencilFlags, LinkMode.BITFIELD),
        uint32_t(
            "_bstencil",
            "back stencil state. If back is set to #STENCIL_NONE {@code _fstencil} is applied to both front and back facing primitives.",
            StencilFlags, LinkMode.BITFIELD
        )
    )

    uint16_t(
        "encoder_set_scissor",
        "Sets scissor for draw primitive. To scissor for all primitives in view see #set_view_scissor().",

        bgfx_encoder_s.p("_this", "the encoder"),
        MapToInt..uint16_t("_x", "position x from the left side of the window"),
        MapToInt..uint16_t("_y", "position y from the top side of the window"),
        MapToInt..uint16_t("_width", "width of scissor region"),
        MapToInt..uint16_t("_height", "height of scissor region"),

        returnDoc = "scissor cache index"
    )

    void(
        "encoder_set_scissor_cached",
        "Sets scissor from cache for draw primitive.",

        bgfx_encoder_s.p("_this", "the encoder"),
        MapToInt..uint16_t("_cache", "index in scissor cache. Pass {@code UINT16_MAX} to have primitive use view scissor instead.")
    )

    uint32_t(
        "encoder_set_transform",
        "Sets model matrix for draw primitive. If it is not called, the model will be rendered with identity model matrix.",

        bgfx_encoder_s.p("_this", "the encoder"),
        MultiType(
            PointerMapping.DATA_FLOAT
        )..void.const.p("_mtx", "pointer to first matrix in array"),
        AutoSize(4 x 4 x 4, "_mtx")..uint16_t("_num", "number of matrices in array"),

        returnDoc = "index into matrix cache in case the same model matrix has to be used for other draw primitive call"
    )

    void(
        "encoder_set_transform_cached",
        "Sets model matrix from matrix cache for draw primitive.",

        bgfx_encoder_s.p("_this", "the encoder"),
        uint32_t("_cache", "index in matrix cache"),
        MapToInt..uint16_t("_num", "number of matrices from cache")
    )

    uint32_t(
        "encoder_alloc_transform",
        """
        Reserves {@code _num} matrices in internal matrix cache.

        Pointer returned can be modifed until #frame() is called.
        """,

        bgfx_encoder_s.p("_this", "the encoder"),
        bgfx_transform_t.p("_transform", "pointer to ##BGFXTransform structure"),
        MapToInt..uint16_t("_num", "number of matrices"),

        returnDoc = "index into matrix cache"
    )

    void(
        "encoder_set_uniform",
        "Sets shader uniform parameter for draw primitive.",

        bgfx_encoder_s.p("_this", "the encoder"),
        bgfx_uniform_handle_t("_handle", "uniform"),
        MultiType(
            PointerMapping.DATA_SHORT,
            PointerMapping.DATA_INT,
            PointerMapping.DATA_LONG,
            PointerMapping.DATA_FLOAT,
            PointerMapping.DATA_DOUBLE
        )..Unsafe..void.const.p("_value", "pointer to uniform data"),
        MapToInt..uint16_t("_num", "number of elements. Passing {@code UINT16_MAX} will use the {@code _num} passed on uniform creation.")
    )

    void(
        "encoder_set_index_buffer",
        "Sets index buffer for draw primitive.",

        bgfx_encoder_s.p("_this", "the encoder"),
        bgfx_index_buffer_handle_t("_handle", "index buffer"),
        uint32_t("_firstIndex", "first index to render"),
        uint32_t("_numIndices", "number of indices to render")
    )

    void(
        "encoder_set_dynamic_index_buffer",
        "Sets index buffer for draw primitive.",

        bgfx_encoder_s.p("_this", "the encoder"),
        bgfx_dynamic_index_buffer_handle_t("_handle", "dynamic index buffer"),
        uint32_t("_firstIndex", "first index to render"),
        uint32_t("_numIndices", "number of indices to render")
    )

    void(
        "encoder_set_transient_index_buffer",
        "Sets index buffer for draw primitive.",

        bgfx_encoder_s.p("_this", "the encoder"),
        bgfx_transient_index_buffer_t.const.p("_tib", "transient index buffer"),
        uint32_t("_firstIndex", "first index to render"),
        uint32_t("_numIndices", "number of indices to render")
    )

    void(
        "encoder_set_vertex_buffer",
        "Sets vertex buffer for draw primitive.",

        bgfx_encoder_s.p("_this", "the encoder"),
        MapToInt..uint8_t("_stream", "vertex stream"),
        bgfx_vertex_buffer_handle_t("_handle", "vertex buffer"),
        uint32_t("_startVertex", "first vertex to render"),
        uint32_t("_numVertices", "number of vertices to render")
    )

    void(
        "encoder_set_vertex_buffer_with_layout",
        "Sets vertex buffer for draw primitive.",

        bgfx_encoder_s.p("_this", "the encoder"),
        MapToInt..uint8_t("_stream", "vertex stream"),
        bgfx_vertex_buffer_handle_t("_handle", "vertex buffer"),
        uint32_t("_startVertex", "first vertex to render"),
        uint32_t("_numVertices", "number of vertices to render"),
        bgfx_vertex_layout_handle_t(
            "_layoutHandle",
            "vertex layout for aliasing vertex buffer. If invalid handle is used, vertex layout used for creation of vertex buffer will be used."
        )
    )

    void(
        "encoder_set_dynamic_vertex_buffer",
        "Sets vertex buffer for draw primitive.",

        bgfx_encoder_s.p("_this", "the encoder"),
        MapToInt..uint8_t("_stream", "vertex stream"),
        bgfx_dynamic_vertex_buffer_handle_t("_handle", "dynamic vertex buffer"),
        uint32_t("_startVertex", "first vertex to render"),
        uint32_t("_numVertices", "number of vertices to render")
    )

    void(
        "encoder_set_dynamic_vertex_buffer_with_layout",
        "Sets vertex buffer for draw primitive.",

        bgfx_encoder_s.p("_this", "the encoder"),
        MapToInt..uint8_t("_stream", "vertex stream"),
        bgfx_dynamic_vertex_buffer_handle_t("_handle", "dynamic vertex buffer"),
        uint32_t("_startVertex", "first vertex to render"),
        uint32_t("_numVertices", "number of vertices to render"),
        bgfx_vertex_layout_handle_t(
            "_layoutHandle",
            "vertex layout for aliasing vertex buffer. If invalid handle is used, vertex layout used for creation of vertex buffer will be used."
        )
    )

    void(
        "encoder_set_transient_vertex_buffer",
        "Sets vertex buffer for draw primitive.",

        bgfx_encoder_s.p("_this", "the encoder"),
        MapToInt..uint8_t("_stream", "vertex stream"),
        bgfx_transient_vertex_buffer_t.const.p("_tvb", "transient vertex buffer"),
        uint32_t("_startVertex", "first vertex to render"),
        uint32_t("_numVertices", "number of vertices to render")
    )

    void(
        "encoder_set_transient_vertex_buffer_with_layout",
        "Sets vertex buffer for draw primitive.",

        bgfx_encoder_s.p("_this", "the encoder"),
        MapToInt..uint8_t("_stream", "vertex stream"),
        bgfx_transient_vertex_buffer_t.const.p("_tvb", "transient vertex buffer"),
        uint32_t("_startVertex", "first vertex to render"),
        uint32_t("_numVertices", "number of vertices to render"),
        bgfx_vertex_layout_handle_t(
            "_layoutHandle",
            "vertex layout for aliasing vertex buffer. If invalid handle is used, vertex layout used for creation of vertex buffer will be used."
        )
    )

    void(
        "encoder_set_vertex_count",
        """
        Set number of vertices for auto generated vertices use in conjuction with {@code gl_VertexID}.

        Availability depends on: #CAPS_VERTEX_ID.
        """,

        bgfx_encoder_s.p("_this", "the encoder"),
        uint32_t("_numVertices", "number of vertices")
    )

    void(
        "encoder_set_instance_data_buffer",
        "Sets instance data buffer for draw primitive.",

        bgfx_encoder_s.p("_this", "the encoder"),
        bgfx_instance_data_buffer_t.const.p("_idb", "transient instance data buffer"),
        uint32_t("_start", "first instance data"),
        uint32_t("_num", "number of data instances")
    )

    void(
        "encoder_set_instance_data_from_vertex_buffer",
        "Set instance data buffer for draw primitive.",

        bgfx_encoder_s.p("_this", "the encoder"),
        bgfx_vertex_buffer_handle_t("_handle", "vertex buffer"),
        uint32_t("_start", "first instance data"),
        uint32_t("_num", "number of data instances")
    )

    void(
        "encoder_set_instance_data_from_dynamic_vertex_buffer",
        "Set instance data buffer for draw primitive.",

        bgfx_encoder_s.p("_this", "the encoder"),
        bgfx_dynamic_vertex_buffer_handle_t("_handle", "dynamic vertex buffer"),
        uint32_t("_start", "first instance data"),
        uint32_t("_num", "number of data instances")
    )

    void(
        "encoder_set_instance_count",
        """
        Sets number of instances for auto generated instances use in conjuction with {@code gl_InstanceID}.

        Availability depends on: #CAPS_VERTEX_ID.
        """,

        bgfx_encoder_s.p("_this", "the encoder"),
        uint32_t("_numInstances", "number of instances")
    )

    void(
        "encoder_set_texture",
        "Sets texture stage for draw primitive.",

        bgfx_encoder_s.p("_this", "the encoder"),
        MapToInt..uint8_t("_stage", "texture unit"),
        bgfx_uniform_handle_t("_sampler", "program sampler"),
        bgfx_texture_handle_t("_handle", "texture handle"),
        uint32_t("_flags", "texture sampling mode. {@code UINT32_MAX} uses texture sampling settings from the texture.", SamplerFlags)
    )

    void(
        "encoder_touch",
        """
        Submits an empty primitive for rendering.

        Uniforms and draw state will be applied but no geometry will be submitted. Useful in cases when no other draw/compute primitive is submitted to view,
        but it's desired to execute clear view.

        These empty draw calls will sort before ordinary draw calls.
        """,

        bgfx_encoder_s.p("_this", "the encoder"),
        MapToInt..bgfx_view_id_t("_id", "view id")
    )

    void(
        "encoder_submit",
        "Submits primitive for rendering.",

        bgfx_encoder_s.p("_this", "the encoder"),
        MapToInt..bgfx_view_id_t("_id", "view id"),
        bgfx_program_handle_t("_handle", "program"),
        uint32_t("_depth", "depth for sorting"),
        MapToInt..uint8_t("_flags", "discard or preserve states", DiscardFlags, LinkMode.BITFIELD)
    )

    void(
        "encoder_submit_occlusion_query",
        "Submits primitive with occlusion query for rendering.",

        bgfx_encoder_s.p("_this", "the encoder"),
        MapToInt..bgfx_view_id_t("_id", "view id"),
        bgfx_program_handle_t("_program", "program"),
        bgfx_occlusion_query_handle_t("_occlusionQuery", "occlusion query"),
        uint32_t("_depth", "depth for sorting"),
        MapToInt..uint8_t("_flags", "discard or preserve states", DiscardFlags, LinkMode.BITFIELD)
    )

    void(
        "encoder_submit_indirect",
        "Submits primitive for rendering with index and instance data info from indirect buffer.",

        bgfx_encoder_s.p("_this", "the encoder"),
        MapToInt..bgfx_view_id_t("_id", "view id"),
        bgfx_program_handle_t("_handle", "program"),
        bgfx_indirect_buffer_handle_t("_indirectHandle", "indirect buffer"),
        MapToInt..uint16_t("_start", "first element in indirect buffer"),
        MapToInt..uint16_t("_num", "number of dispatches"),
        uint32_t("_depth", "depth for sorting"),
        MapToInt..uint8_t("_flags", "discard or preserve states", DiscardFlags, LinkMode.BITFIELD)
    )

    void(
        "encoder_set_compute_index_buffer",
        "Sets compute index buffer.",

        bgfx_encoder_s.p("_this", "the encoder"),
        MapToInt..uint8_t("_stage", "compute stage"),
        bgfx_index_buffer_handle_t("_handle", "index buffer handle"),
        bgfx_access_t("_access", "buffer access", Access)
    )

    void(
        "encoder_set_compute_vertex_buffer",
        "Sets compute vertex buffer.",

        bgfx_encoder_s.p("_this", "the encoder"),
        MapToInt..uint8_t("_stage", "compute stage"),
        bgfx_vertex_buffer_handle_t("_handle", "vertex buffer handle"),
        bgfx_access_t("_access", "buffer access", Access)
    )

    void(
        "encoder_set_compute_dynamic_index_buffer",
        "Sets compute dynamic index buffer.",

        bgfx_encoder_s.p("_this", "the encoder"),
        MapToInt..uint8_t("_stage", "compute stage"),
        bgfx_dynamic_index_buffer_handle_t("_handle", "dynamic index buffer handle"),
        bgfx_access_t("_access", "buffer access", Access)
    )

    void(
        "encoder_set_compute_dynamic_vertex_buffer",
        "Sets compute dynamic vertex buffer.",

        bgfx_encoder_s.p("_this", "the encoder"),
        MapToInt..uint8_t("_stage", "compute stage"),
        bgfx_dynamic_vertex_buffer_handle_t("_handle", "dynamic vertex buffer handle"),
        bgfx_access_t("_access", "buffer access", Access)
    )

    void(
        "encoder_set_compute_indirect_buffer",
        "Sets compute indirect buffer.",

        bgfx_encoder_s.p("_this", "the encoder"),
        MapToInt..uint8_t("_stage", "compute stage"),
        bgfx_indirect_buffer_handle_t("_handle", "indirect buffer handle"),
        bgfx_access_t("_access", "buffer access", Access)
    )

    void(
        "encoder_set_image",
        "Sets compute image from texture.",

        bgfx_encoder_s.p("_this", "the encoder"),
        MapToInt..uint8_t("_stage", "texture unit"),
        bgfx_texture_handle_t("_handle", "texture handle"),
        MapToInt..uint8_t("_mip", "mip level"),
        bgfx_access_t("_access", "texture access", Access),
        bgfx_texture_format_t("_format", "texture format", TextureFormat)
    )

    void(
        "encoder_dispatch",
        "Dispatches compute.",

        bgfx_encoder_s.p("_this", "the encoder"),
        MapToInt..bgfx_view_id_t("_id", "view id"),
        bgfx_program_handle_t("_handle", "compute program"),
        uint32_t("_numX", "number of groups X"),
        uint32_t("_numY", "number of groups Y"),
        uint32_t("_numZ", "number of groups Z"),
        MapToInt..uint8_t("_flags", "discard or preserve states", DiscardFlags, LinkMode.BITFIELD)
    )

    void(
        "encoder_dispatch_indirect",
        "Dispatches compute indirect.",

        bgfx_encoder_s.p("_this", "the encoder"),
        MapToInt..bgfx_view_id_t("_id", "view id"),
        bgfx_program_handle_t("_handle", "compute program"),
        bgfx_indirect_buffer_handle_t("_indirectHandle", "indirect buffer"),
        MapToInt..uint16_t("_start", "first element in indirect buffer"),
        MapToInt..uint16_t("_num", "number of dispatches"),
        MapToInt..uint8_t("_flags", "discard or preserve states", DiscardFlags, LinkMode.BITFIELD)
    )

    void(
        "encoder_discard",
        "Discards all previously set state for draw or compute call.",

        bgfx_encoder_s.p("_this", "the encoder"),
        MapToInt..uint8_t("_flags", "discard or preserve states", DiscardFlags, LinkMode.BITFIELD)
    )

    void(
        "encoder_blit",
        """
        Blits texture region between two textures.

        Destination texture must be created with #TEXTURE_BLIT_DST flag. Availability depends on #CAPS_TEXTURE_BLIT.
        """,

        bgfx_encoder_s.p("_this", "the encoder"),
        MapToInt..bgfx_view_id_t("_id", "view id"),
        bgfx_texture_handle_t("_dst", "destination texture handle"),
        MapToInt..uint8_t("_dstMip", "destination texture mip level"),
        MapToInt..uint16_t("_dstX", "destination texture X position"),
        MapToInt..uint16_t("_dstY", "destination texture Y position"),
        MapToInt..uint16_t(
            "_dstZ",
            """
            if texture is 2D this argument should be 0. If destination texture is cube this argument represents destination texture cube face. For 3D texture
            this argument represents destination texture Z position.
            """
        ),
        bgfx_texture_handle_t("_src", "source texture handle"),
        MapToInt..uint8_t("_srcMip", "source texture mip level"),
        MapToInt..uint16_t("_srcX", "source texture X position"),
        MapToInt..uint16_t("_srcY", "source texture Y position"),
        MapToInt..uint16_t(
            "_srcZ",
            """
            if texture is 2D this argument should be 0. If destination texture is cube this argument represents destination texture cube face. For 3D texture
            this argument represent destination texture Z position.
            """
        ),
        MapToInt..uint16_t("_width", "width of region"),
        MapToInt..uint16_t("_height", "height of region"),
        MapToInt..uint16_t("_depth", "if texture is 3D this argument represents depth of region, otherwise it's unused")
    )

    void(
        "request_screen_shot",
        "Requests screen shot.",

        bgfx_frame_buffer_handle_t("_handle", "frame buffer handle"),
        charASCII.const.p("_filePath", "will be passed to ##BGFXScreenShotCallback")
    )

    void(
        "set_marker",
        "Sets debug marker.",

        charASCII.const.p("_marker", "debug marker")
    )

    void(
        "set_state",
        """
        Sets render states for draw primitive.

        Remarks:
        ${ol(
            """
            To setup more complex states use:
            ${codeBlock("""
BGFX_STATE_ALPHA_REF(_ref),
BGFX_STATE_POINT_SIZE(_size),
BGFX_STATE_BLEND_FUNC(_src, _dst),
BGFX_STATE_BLEND_FUNC_SEPARATE(_srcRGB, _dstRGB, _srcA, _dstA)
BGFX_STATE_BLEND_EQUATION(_equation)
BGFX_STATE_BLEND_EQUATION_SEPARATE(_equationRGB, _equationA)""")}
            """,
            "#STATE_BLEND_EQUATION_ADD is set when no other blend equation is specified."
        )}
        """,

        uint64_t("_state", "state flags", StateFlags, LinkMode.BITFIELD),
        uint32_t("_rgba", "blend factor used by #STATE_BLEND_FACTOR and #STATE_BLEND_INV_FACTOR blend modes")
    )

    void(
        "set_condition",
        "Sets condition for rendering.",

        bgfx_occlusion_query_handle_t("_handle", "occlusion query handle"),
        bool("_visible", "render if occlusion query is visible")
    )

    void(
        "set_stencil",
        "Sets stencil test state.",

        uint32_t("_fstencil", "front stencil state", StencilFlags, LinkMode.BITFIELD),
        uint32_t(
            "_bstencil",
            "back stencil state. If back is set to #STENCIL_NONE {@code _fstencil} is applied to both front and back facing primitives.",
            StencilFlags, LinkMode.BITFIELD
        )
    )

    uint16_t(
        "set_scissor",
        "Sets scissor for draw primitive. For scissor for all primitives in view see #set_view_scissor().",

        MapToInt..uint16_t("_x", "position x from the left corner of the window"),
        MapToInt..uint16_t("_y", "position y from the top corner of the window"),
        MapToInt..uint16_t("_width", "width of scissor region"),
        MapToInt..uint16_t("_height", "height of scissor region"),

        returnDoc = "scissor cache index"
    )

    void(
        "set_scissor_cached",
        "Sets scissor from cache for draw primitive.",

        MapToInt..uint16_t("_cache", "index in scissor cache. Passing {@code UINT16_MAX} unsets primitive scissor and primitive will use view scissor instead.")
    )

    uint32_t(
        "set_transform",
        "Sets model matrix for draw primitive. If it is not called model will be rendered with identity model matrix.",

        MultiType(
            PointerMapping.DATA_FLOAT
        )..void.const.p("_mtx", "pointer to first matrix in array"),
        AutoSize(4 x 4 x 4, "_mtx")..uint16_t("_num", "number of matrices in array"),

        returnDoc = "index into matrix cache in case the same model matrix has to be used for other draw primitive call"
    )

    void(
        "set_transform_cached",
        "Sets model matrix from matrix cache for draw primitive.",

        uint32_t("_cache", "index in matrix cache"),
        MapToInt..uint16_t("_num", "number of matrices from cache")
    )

    uint32_t(
        "alloc_transform",
        """
        Reserves {@code _num} matrices in internal matrix cache.

        Pointer returned can be modifed until #frame() is called.
        """,

        bgfx_transform_t.p("_transform", "pointer to ##BGFXTransform structure"),
        MapToInt..uint16_t("_num", "number of matrices"),

        returnDoc = "index into matrix cache"
    )

    void(
        "set_uniform",
        "Sets shader uniform parameter for draw primitive.",

        bgfx_uniform_handle_t("_handle", "uniform"),
        MultiType(
            PointerMapping.DATA_SHORT,
            PointerMapping.DATA_INT,
            PointerMapping.DATA_LONG,
            PointerMapping.DATA_FLOAT,
            PointerMapping.DATA_DOUBLE
        )..Unsafe..void.const.p("_value", "pointer to uniform data"),
        MapToInt..uint16_t("_num", "number of elements. Passing {@code UINT16_MAX} will use the {@code _num} passed on uniform creation.")
    )

    void(
        "set_index_buffer",
        "Sets index buffer for draw primitive.",

        bgfx_index_buffer_handle_t("_handle", "index buffer"),
        uint32_t("_firstIndex", "first index to render"),
        uint32_t("_numIndices", "number of indices to render")
    )

    void(
        "set_dynamic_index_buffer",
        "Sets index buffer for draw primitive.",

        bgfx_dynamic_index_buffer_handle_t("_handle", "dynamic index buffer"),
        uint32_t("_firstIndex", "first index to render"),
        uint32_t("_numIndices", "number of indices to render")
    )

    void(
        "set_transient_index_buffer",
        "Sets index buffer for draw primitive.",

        bgfx_transient_index_buffer_t.const.p("_tib", "transient index buffer"),
        uint32_t("_firstIndex", "first index to render"),
        uint32_t("_numIndices", "number of indices to render")
    )

    void(
        "set_vertex_buffer",
        "Sets vertex buffer for draw primitive.",

        MapToInt..uint8_t("_stream", "vertex stream"),
        bgfx_vertex_buffer_handle_t("_handle", "vertex buffer"),
        uint32_t("_startVertex", "first vertex to render"),
        uint32_t("_numVertices", "number of vertices to render")
    )

    void(
        "set_vertex_buffer_with_layout",
        "Sets vertex buffer for draw primitive.",

        MapToInt..uint8_t("_stream", "vertex stream"),
        bgfx_vertex_buffer_handle_t("_handle", "vertex buffer"),
        uint32_t("_startVertex", "first vertex to render"),
        uint32_t("_numVertices", "number of vertices to render"),
        bgfx_vertex_layout_handle_t(
            "_layoutHandle",
            "vertex layout for aliasing vertex buffer. If invalid handle is used, vertex layout used for creation of vertex buffer will be used."
        )
    )

    void(
        "set_dynamic_vertex_buffer",
        "Sets vertex buffer for draw primitive.",

        MapToInt..uint8_t("_stream", "vertex stream"),
        bgfx_dynamic_vertex_buffer_handle_t("_handle", "dynamic vertex buffer"),
        uint32_t("_startVertex", "first vertex to render"),
        uint32_t("_numVertices", "number of vertices to render")
    )

    void(
        "set_dynamic_vertex_buffer_with_layout",
        "Sets vertex buffer for draw primitive.",

        MapToInt..uint8_t("_stream", "vertex stream"),
        bgfx_dynamic_vertex_buffer_handle_t("_handle", "dynamic vertex buffer"),
        uint32_t("_startVertex", "first vertex to render"),
        uint32_t("_numVertices", "number of vertices to render"),
        bgfx_vertex_layout_handle_t(
            "_layoutHandle",
            "vertex layout for aliasing vertex buffer. If invalid handle is used, vertex layout used for creation of vertex buffer will be used."
        )
    )

    void(
        "set_transient_vertex_buffer",
        "Sets vertex buffer for draw primitive.",

        MapToInt..uint8_t("_stream", "vertex stream"),
        bgfx_transient_vertex_buffer_t.const.p("_tvb", "transient vertex buffer"),
        uint32_t("_startVertex", "first vertex to render"),
        uint32_t("_numVertices", "number of vertices to render")
    )

    void(
        "set_transient_vertex_buffer_with_layout",
        "Sets vertex buffer for draw primitive.",

        MapToInt..uint8_t("_stream", "vertex stream"),
        bgfx_transient_vertex_buffer_t.const.p("_tvb", "transient vertex buffer"),
        uint32_t("_startVertex", "first vertex to render"),
        uint32_t("_numVertices", "number of vertices to render"),
        bgfx_vertex_layout_handle_t(
            "_layoutHandle",
            "vertex layout for aliasing vertex buffer. If invalid handle is used, vertex layout used for creation of vertex buffer will be used."
        )
    )

    void(
        "set_vertex_count",
        """
        Set number of vertices for auto generated vertices use in conjuction with {@code gl_VertexID}.

        Availability depends on: #CAPS_VERTEX_ID.
        """,

        uint32_t("_numVertices", "number of vertices")
    )

    void(
        "set_instance_data_buffer",
        "Sets instance data buffer for draw primitive.",

        bgfx_instance_data_buffer_t.const.p("_idb", "transient instance data buffer"),
        uint32_t("_start", "first instance data"),
        uint32_t("_num", "number of data instances")
    )

    void(
        "set_instance_data_from_vertex_buffer",
        "Set instance data buffer for draw primitive.",

        bgfx_vertex_buffer_handle_t("_handle", "vertex buffer"),
        uint32_t("_start", "first instance data"),
        uint32_t("_num", "number of data instances")
    )

    void(
        "set_instance_data_from_dynamic_vertex_buffer",
        "Set instance data buffer for draw primitive.",

        bgfx_dynamic_vertex_buffer_handle_t("_handle", "dynamic vertex buffer"),
        uint32_t("_start", "first instance data"),
        uint32_t("_num", "number of data instances")
    )

    void(
        "set_instance_count",
        """
        Sets number of instances for auto generated instances use in conjuction with {@code gl_InstanceID}.

        Availability depends on: #CAPS_VERTEX_ID.
        """,

        uint32_t("_numInstances", "number of instances")
    )

    void(
        "set_texture",
        "Sets texture stage for draw primitive.",

        MapToInt..uint8_t("_stage", "texture unit"),
        bgfx_uniform_handle_t("_sampler", "program sampler"),
        bgfx_texture_handle_t("_handle", "texture handle"),
        uint32_t("_flags", "texture sampling mode. {@code UINT32_MAX} uses texture sampling settings from the texture.", SamplerFlags)
    )

    void(
        "touch",
        """
        Submits an empty primitive for rendering. Uniforms and draw state will be applied but no geometry will be submitted.

        These empty draw calls will sort before ordinary draw calls.
        """,

        MapToInt..bgfx_view_id_t("_id", "view id")
    )

    void(
        "submit",
        "Submits primitive for rendering.",

        MapToInt..bgfx_view_id_t("_id", "view id"),
        bgfx_program_handle_t("_program", "program"),
        uint32_t("_depth", "depth for sorting"),
        MapToInt..uint8_t("_flags", "which states to discard for next draw", DiscardFlags, LinkMode.BITFIELD)
    )

    void(
        "submit_occlusion_query",
        "Submits primitive with occlusion query for rendering.",

        MapToInt..bgfx_view_id_t("_id", "view id"),
        bgfx_program_handle_t("_program", "program"),
        bgfx_occlusion_query_handle_t("_occlusionQuery", "occlusion query"),
        uint32_t("_depth", "depth for sorting"),
        MapToInt..uint8_t("_flags", "which states to discard for next draw", DiscardFlags, LinkMode.BITFIELD)
    )

    void(
        "submit_indirect",
        "Submits primitive for rendering with index and instance data info from indirect buffer.",

        MapToInt..bgfx_view_id_t("_id", "view id"),
        bgfx_program_handle_t("_program", "program"),
        bgfx_indirect_buffer_handle_t("_indirectHandle", "indirect buffer"),
        MapToInt..uint16_t("_start", "first element in indirect buffer"),
        MapToInt..uint16_t("_num", "number of dispatches"),
        uint32_t("_depth", "depth for sorting"),
        MapToInt..uint8_t("_flags", "which states to discard for next draw", DiscardFlags, LinkMode.BITFIELD)
    )

    void(
        "set_compute_index_buffer",
        "Sets compute index buffer.",

        MapToInt..uint8_t("_stage", "compute stage"),
        bgfx_index_buffer_handle_t("_handle", "index buffer handle"),
        bgfx_access_t("_access", "buffer access", Access)
    )

    void(
        "set_compute_vertex_buffer",
        "Sets compute vertex buffer.",

        MapToInt..uint8_t("_stage", "compute stage"),
        bgfx_vertex_buffer_handle_t("_handle", "vertex buffer handle"),
        bgfx_access_t("_access", "buffer access", Access)
    )

    void(
        "set_compute_dynamic_index_buffer",
        "Sets compute dynamic index buffer.",

        MapToInt..uint8_t("_stage", "compute stage"),
        bgfx_dynamic_index_buffer_handle_t("_handle", "dynamic index buffer handle"),
        bgfx_access_t("_access", "buffer access", Access)
    )

    void(
        "set_compute_dynamic_vertex_buffer",
        "Sets compute dynamic vertex buffer.",

        MapToInt..uint8_t("_stage", "compute stage"),
        bgfx_dynamic_vertex_buffer_handle_t("_handle", "dynamic vertex buffer handle"),
        bgfx_access_t("_access", "buffer access", Access)
    )

    void(
        "set_compute_indirect_buffer",
        "Sets compute indirect buffer.",

        MapToInt..uint8_t("_stage", "compute stage"),
        bgfx_indirect_buffer_handle_t("_handle", "indirect buffer handle"),
        bgfx_access_t("_access", "buffer access", Access)
    )

    void(
        "set_image",
        "Sets compute image from texture.",

        MapToInt..uint8_t("_stage", "texture unit"),
        bgfx_texture_handle_t("_handle", "texture handle"),
        MapToInt..uint8_t("_mip", "mip level"),
        bgfx_access_t("_access", "texture access", Access),
        bgfx_texture_format_t("_format", "texture format", TextureFormat)
    )

    void(
        "dispatch",
        "Dispatches compute.",

        MapToInt..bgfx_view_id_t("_id", "view id"),
        bgfx_program_handle_t("_program", "compute program"),
        uint32_t("_numX", "number of groups X"),
        uint32_t("_numY", "number of groups Y"),
        uint32_t("_numZ", "number of groups Z"),
        MapToInt..uint8_t("_flags", "discard or preserve states", DiscardFlags, LinkMode.BITFIELD)
    )

    void(
        "dispatch_indirect",
        "Dispatches compute indirect.",

        MapToInt..bgfx_view_id_t("_id", "view id"),
        bgfx_program_handle_t("_program", "compute program"),
        bgfx_indirect_buffer_handle_t("_indirectHandle", "indirect buffer"),
        MapToInt..uint16_t("_start", "first element in indirect buffer"),
        MapToInt..uint16_t("_num", "number of dispatches"),
        MapToInt..uint8_t("_flags", "discard or preserve states", DiscardFlags, LinkMode.BITFIELD)
    )

    void(
        "discard",
        "Discards all previously set state for draw or compute call.",

        MapToInt..uint8_t("_flags", "draw/compute states to discard", DiscardFlags, LinkMode.BITFIELD)
    )

    void(
        "blit",
        """
        Blits texture region between two textures.

        Destination texture must be created with #TEXTURE_BLIT_DST flag. Availability depends on #CAPS_TEXTURE_BLIT.
        """,

        MapToInt..bgfx_view_id_t("_id", "view id"),
        bgfx_texture_handle_t("_dst", "destination texture handle"),
        MapToInt..uint8_t("_dstMip", "destination texture mip level"),
        MapToInt..uint16_t("_dstX", "destination texture X position"),
        MapToInt..uint16_t("_dstY", "destination texture Y position"),
        MapToInt..uint16_t(
            "_dstZ",
            """
            if texture is 2D this argument should be 0. If destination texture is cube this argument represents destination texture cube face. For 3D texture
            this argument represents destination texture Z position.
            """
        ),
        bgfx_texture_handle_t("_src", "source texture handle"),
        MapToInt..uint8_t("_srcMip", "source texture mip level"),
        MapToInt..uint16_t("_srcX", "source texture X position"),
        MapToInt..uint16_t("_srcY", "source texture Y position"),
        MapToInt..uint16_t(
            "_srcZ",
            """
            if texture is 2D this argument should be 0. If destination texture is cube this argument represents destination texture cube face. For 3D texture
            this argument represents destination texture Z position.
            """
        ),
        MapToInt..uint16_t("_width", "width of region"),
        MapToInt..uint16_t("_height", "height of region"),
        MapToInt..uint16_t("_depth", "if texture is 3D this argument represents depth of region, otherwise it's unused")
    )

    macro(expression = "(_ref << BGFX_STATE_ALPHA_REF_SHIFT) & BGFX_STATE_ALPHA_REF_MASK")..uint64_t(
        "BGFX_STATE_ALPHA_REF", "",
        uint64_t("_ref", ""),
        noPrefix = true
    )

    macro(expression = "(_size << BGFX_STATE_POINT_SIZE_SHIFT) & BGFX_STATE_POINT_SIZE_MASK")..uint64_t(
        "BGFX_STATE_POINT_SIZE", "",
        uint64_t("_size", ""),
        noPrefix = true
    )

    macro(expression = "((_srcRGB | (_dstRGB << 4))) | ((_srcA | (_dstA << 4)) << 8)")..uint64_t(
        "BGFX_STATE_BLEND_FUNC_SEPARATE", "",
        uint64_t("_srcRGB", ""),
        uint64_t("_dstRGB", ""),
        uint64_t("_srcA", ""),
        uint64_t("_dstA", ""),
        noPrefix = true
    )

    macro(expression = "_rgb | (_a << 3)")..uint64_t(
        "BGFX_STATE_BLEND_EQUATION_SEPARATE", "",
        uint64_t("_rgb", ""),
        uint64_t("_a", ""),
        noPrefix = true
    )

    macro(expression = "BGFX_STATE_BLEND_FUNC_SEPARATE(_src, _dst, _src, _dst)")..uint64_t(
        "BGFX_STATE_BLEND_FUNC", "",
        uint64_t("_src", ""),
        uint64_t("_dst", ""),
        noPrefix = true
    )

    macro(expression = "BGFX_STATE_BLEND_EQUATION_SEPARATE(_equation, _equation)")..uint64_t(
        "BGFX_STATE_BLEND_EQUATION", "",
        uint64_t("_equation", ""),
        noPrefix = true
    )

    LongConstant(
        "Blend state macros",

        "STATE_BLEND_ADD".."BGFX_STATE_BLEND_FUNC(BGFX_STATE_BLEND_ONE, BGFX_STATE_BLEND_ONE)",
        "STATE_BLEND_ALPHA".."BGFX_STATE_BLEND_FUNC(BGFX_STATE_BLEND_SRC_ALPHA, BGFX_STATE_BLEND_INV_SRC_ALPHA)",
        "STATE_BLEND_DARKEN".."BGFX_STATE_BLEND_FUNC(BGFX_STATE_BLEND_ONE, BGFX_STATE_BLEND_ONE) | BGFX_STATE_BLEND_EQUATION(BGFX_STATE_BLEND_EQUATION_MIN)",
        "STATE_BLEND_LIGHTEN".."BGFX_STATE_BLEND_FUNC(BGFX_STATE_BLEND_ONE, BGFX_STATE_BLEND_ONE) | BGFX_STATE_BLEND_EQUATION(BGFX_STATE_BLEND_EQUATION_MAX)",
        "STATE_BLEND_MULTIPLY".."BGFX_STATE_BLEND_FUNC(BGFX_STATE_BLEND_DST_COLOR, BGFX_STATE_BLEND_ZERO)",
        "STATE_BLEND_NORMAL".."BGFX_STATE_BLEND_FUNC(BGFX_STATE_BLEND_ONE, BGFX_STATE_BLEND_INV_SRC_ALPHA)",
        "STATE_BLEND_SCREEN".."BGFX_STATE_BLEND_FUNC(BGFX_STATE_BLEND_ONE, BGFX_STATE_BLEND_INV_SRC_COLOR)",
        "STATE_BLEND_LINEAR_BURN".."BGFX_STATE_BLEND_FUNC(BGFX_STATE_BLEND_DST_COLOR, BGFX_STATE_BLEND_INV_DST_COLOR) | BGFX_STATE_BLEND_EQUATION(BGFX_STATE_BLEND_EQUATION_SUB)"
    )

    macro(expression = "(_src >> BGFX_STATE_BLEND_SHIFT) | ((_dst >> BGFX_STATE_BLEND_SHIFT) << 4)")..uint64_t(
        "BGFX_STATE_BLEND_FUNC_RT_x", "",
        uint64_t("_src", ""),
        uint64_t("_dst", ""),
        noPrefix = true
    )

    macro(expression = "BGFX_STATE_BLEND_FUNC_RT_x(_src, _dst) | ((_equation >> BGFX_STATE_BLEND_EQUATION_SHIFT) << 8)")..uint64_t(
        "BGFX_STATE_BLEND_FUNC_RT_xE", "",
        uint64_t("_src", ""),
        uint64_t("_dst", ""),
        uint64_t("_equation", ""),
        noPrefix = true
    )

    macro(expression = "BGFX_STATE_BLEND_FUNC_RT_x(_src, _dst) << 0")..uint64_t(
        "BGFX_STATE_BLEND_FUNC_RT_1", "",
        uint64_t("_src", ""),
        uint64_t("_dst", ""),
        noPrefix = true
    )

    macro(expression = "BGFX_STATE_BLEND_FUNC_RT_x(_src, _dst) << 11")..uint64_t(
        "BGFX_STATE_BLEND_FUNC_RT_2", "",
        uint64_t("_src", ""),
        uint64_t("_dst", ""),
        noPrefix = true
    )

    macro(expression = "BGFX_STATE_BLEND_FUNC_RT_x(_src, _dst) << 22")..uint64_t(
        "BGFX_STATE_BLEND_FUNC_RT_3", "",
        uint64_t("_src", ""),
        uint64_t("_dst", ""),
        noPrefix = true
    )

    macro(expression = "BGFX_STATE_BLEND_FUNC_RT_xE(_src, _dst, _equation) << 0")..uint64_t(
        "BGFX_STATE_BLEND_FUNC_RT_1E", "",
        uint64_t("_src", ""),
        uint64_t("_dst", ""),
        uint64_t("_equation", ""),
        noPrefix = true
    )

    macro(expression = "BGFX_STATE_BLEND_FUNC_RT_xE(_src, _dst, _equation) << 11")..uint64_t(
        "BGFX_STATE_BLEND_FUNC_RT_2E", "",
        uint64_t("_src", ""),
        uint64_t("_dst", ""),
        uint64_t("_equation", ""),
        noPrefix = true
    )

    macro(expression = "BGFX_STATE_BLEND_FUNC_RT_xE(_src, _dst, _equation) << 22")..uint64_t(
        "BGFX_STATE_BLEND_FUNC_RT_3E", "",
        uint64_t("_src", ""),
        uint64_t("_dst", ""),
        uint64_t("_equation", ""),
        noPrefix = true
    )

    macro(expression = "(_ref << BGFX_STENCIL_FUNC_REF_SHIFT) & BGFX_STENCIL_FUNC_REF_MASK")..uint32_t(
        "BGFX_STENCIL_FUNC_REF", "",
        uint32_t("_ref", ""),
        noPrefix = true
    )

    macro(expression = "(_mask << BGFX_STENCIL_FUNC_RMASK_SHIFT) & BGFX_STENCIL_FUNC_RMASK_MASK")..uint32_t(
        "BGFX_STENCIL_FUNC_RMASK", "",
        uint32_t("_mask", ""),
        noPrefix = true
    )

    macro(expression = "(_index << BGFX_SAMPLER_BORDER_COLOR_SHIFT) & BGFX_SAMPLER_BORDER_COLOR_MASK")..uint32_t(
        "BGFX_SAMPLER_BORDER_COLOR", "",
        uint32_t("_index", ""),
        noPrefix = true
    )

    macro(expression = "Short.toUnsignedInt(h) != 0xFFFF")..bool(
        "BGFX_HANDLE_IS_VALID", "",
        uint16_t("h", ""),
        noPrefix = true
    )
}