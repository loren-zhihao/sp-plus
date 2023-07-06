// 定义菜单列表
var menuList =	[
	{
		name: 'spSemicType',
		path: '/spSemicType',
		component: Layout,
        meta: {
          title: '类型表',
          icon: 'el-icon-folder-opened'
        },
		children: [
            {
                name: 'spSemicType-list',
                path: 'spSemicType-list',
                component: () => import('@/sp-views/sp-semic-type/sp-semic-type-list.vue'),
                meta: { title: '类型表-列表' }
            },
            {
                name: 'spSemicType-add',
                path: 'spSemicType-add',
                component: () => import('@/sp-views/sp-semic-type/sp-semic-type-add.vue'),
                meta: { title: '类型表-新增' }
            },
            {
                name: 'spSemicType-info',
                path: 'spSemicType-info',
                component: () => import('@/sp-views/sp-semic-type/sp-semic-type-info.vue'),
                meta: { title: '类型表-详情' }
            },
		]
	},
	{
		name: 'spSemicDictionary',
		path: '/spSemicDictionary',
		component: Layout,
        meta: {
          title: '半导体词典表',
          icon: 'el-icon-folder-opened'
        },
		children: [
            {
                name: 'spSemicDictionary-list',
                path: 'spSemicDictionary-list',
                component: () => import('@/sp-views/sp-semic-dictionary/sp-semic-dictionary-list.vue'),
                meta: { title: '半导体词典表-列表' }
            },
            {
                name: 'spSemicDictionary-add',
                path: 'spSemicDictionary-add',
                component: () => import('@/sp-views/sp-semic-dictionary/sp-semic-dictionary-add.vue'),
                meta: { title: '半导体词典表-新增' }
            },
            {
                name: 'spSemicDictionary-info',
                path: 'spSemicDictionary-info',
                component: () => import('@/sp-views/sp-semic-dictionary/sp-semic-dictionary-info.vue'),
                meta: { title: '半导体词典表-详情' }
            },
		]
	},
	{
		name: 'spSemicChildDictionary',
		path: '/spSemicChildDictionary',
		component: Layout,
        meta: {
          title: '半导体词典表的子集信息',
          icon: 'el-icon-folder-opened'
        },
		children: [
            {
                name: 'spSemicChildDictionary-list',
                path: 'spSemicChildDictionary-list',
                component: () => import('@/sp-views/sp-semic-child-dictionary/sp-semic-child-dictionary-list.vue'),
                meta: { title: '半导体词典表的子集信息-列表' }
            },
            {
                name: 'spSemicChildDictionary-add',
                path: 'spSemicChildDictionary-add',
                component: () => import('@/sp-views/sp-semic-child-dictionary/sp-semic-child-dictionary-add.vue'),
                meta: { title: '半导体词典表的子集信息-新增' }
            },
            {
                name: 'spSemicChildDictionary-info',
                path: 'spSemicChildDictionary-info',
                component: () => import('@/sp-views/sp-semic-child-dictionary/sp-semic-child-dictionary-info.vue'),
                meta: { title: '半导体词典表的子集信息-详情' }
            },
		]
	},
]